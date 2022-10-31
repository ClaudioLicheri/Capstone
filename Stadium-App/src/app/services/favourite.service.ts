import { Injectable } from '@angular/core';
import { FavouriteDTO } from 'src/models/favouritedto';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AbstractService } from './abstract.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FavouriteService  extends AbstractService<FavouriteDTO>{

constructor(http: HttpClient) {
  super(http);
    this.type = 'favourite';
}

public getAllByUserId(id: number): Observable<FavouriteDTO[]> {
  return this.http.get<FavouriteDTO[]>(environment.APIEndpoint + this.type + "/getmine?id=" + id)
}

}
