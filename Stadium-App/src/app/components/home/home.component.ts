import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventService } from 'src/app/services/event.service';
import { TicketService } from 'src/app/services/ticket.service';
import { EventDTO } from 'src/models/eventdto';
import { TicketDTO } from 'src/models/ticketdto';
import { UserDTO } from 'src/models/userdto';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private router: Router, private service: EventService, private ticketService: TicketService) { }

  public user!: UserDTO;
  public event!: EventDTO[];
  public ticket!: TicketDTO[];



  public singleEvent: EventDTO = new EventDTO;
  public role!: number;

  ngOnInit(): void {

    this.user = JSON.parse(localStorage.getItem('currentUser') as string);
    if(this.user.usertype==="USER"){
      this.role = 2;
    }
    else{
      this.role = 0;
    }
    if(this.user.usertype === "ADMIN"){
      this.service.getAllByUserId(this.user.id).subscribe(event => {
        this.event = event;
        console.log(event)
      });
    }
    else{
     this.getEvents()
    }
  }

  getEvents() {
    this.service.getAll().subscribe(event => {
      this.event = event
    });
  }

 /* addFavourites(user: UserDTO, event: EventDTO){
    this.service.addFavourites().subscribe(() => this.service.getAll());
  }*/


  delete(event: EventDTO) {
    this.service.delete(event.id).subscribe(() => this.getEvents());
  }

  buyTicket(ticket:TicketDTO) {
    this.ticketService.buyTicket(ticket).subscribe(() => this.ticketService.insert(ticket));
    console.log(ticket);


  }

  



}
