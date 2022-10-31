import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EventService } from 'src/app/services/event.service';
import { EventDTO } from 'src/models/eventdto';

import { UserDTO } from 'src/models/userdto';

@Component({
  selector: 'app-edit-event',
  templateUrl: './edit-event.component.html',
  styleUrls: ['./edit-event.component.css']
})
export class EditEventComponent implements OnInit {

  constructor(private router: Router, private actRoute: ActivatedRoute, private service: EventService) { }

  public eventId: number;
  public event: EventDTO = new EventDTO();
  public user!: UserDTO;
  public role!: number;
  public name!: string;
  public placesAvailable: number;
  public maxCapacity!: number;
  public stadiumName!: string;
  public eventDate!: Date;

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('currentUser') as string);
    this.eventId = this.actRoute.snapshot.params['id'];
    this.service.eventRead(this.eventId).subscribe(event => {
      this.event = event
    })
    if(this.user.usertype==="ADMINISTRATOR"){
      this.role = 0;
    }
    else{
      this.role = 1;
    }

  }
  public handleSubmit(form: NgForm): void {
    if (form.invalid) {
      return;
    } else {
      console.log(this.event);
      this.service.editEvent(this.event).subscribe(() => {
        this.router.navigate(['home'])
      })
    }

  }

}
