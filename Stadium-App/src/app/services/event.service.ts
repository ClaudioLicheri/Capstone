import { Injectable } from '@angular/core';
import { AbstractService } from './abstract.service';
import { HttpClient } from '@angular/common/http';
import { EventDTO } from 'src/models/eventdto';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


/**
 * I service sono decorati da @Injectable.
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 *
 * @author Vittorio Valent
 *
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class EventService extends AbstractService<EventDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'event';
  }

  public createEvent(eventDTO: EventDTO): Observable<EventDTO> {
    return this.http.post<EventDTO>(environment.APIEndpoint + this.type + '/insert', eventDTO)
  }

  public eventRead(id: number): Observable<EventDTO> {
    return this.http.get<EventDTO>(environment.APIEndpoint + this.type + "/read?id=" + id)
  }

  public editEvent(eventDTO: EventDTO): Observable<EventDTO> {
    return this.http.put<EventDTO>(environment.APIEndpoint + this.type + "/update", eventDTO)
  }

  public getAllByUserId(id: number): Observable<EventDTO[]> {
    return this.http.get<EventDTO[]>(environment.APIEndpoint + this.type + "/getmine?id=" + id)
  }

}

