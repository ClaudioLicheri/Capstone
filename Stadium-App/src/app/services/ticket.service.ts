import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TicketDTO } from 'src/models/ticketdto';
import { AbstractService } from './abstract.service';

@Injectable({
  providedIn: 'root'
})
export class TicketService extends AbstractService<TicketDTO>  {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'ticket';}
}
