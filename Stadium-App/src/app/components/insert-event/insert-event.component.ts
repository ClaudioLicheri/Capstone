import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EventService } from 'src/app/services/event.service';
import { UserService } from 'src/app/services/user.service';
import { EventDTO } from 'src/models/eventdto';
import { UserDTO } from 'src/models/userdto';


@Component({
  selector: 'app-insert-event',
  templateUrl: './insert-event.component.html',
  styleUrls: ['./insert-event.component.css']
})
export class InsertEventComponent implements OnInit {

  users: UserDTO[] = [];

  constructor(private router: Router, private service: EventService, private service_2: UserService) { }



    public event: EventDTO = new EventDTO();
    public user: UserDTO = new UserDTO();

    public name!: string;
    public placesAvailable: number;
    public maxCapacity!: number;
    public stadiumName!: string;
    public eventDate!: Date;

    ngOnInit(): void {
      this.service_2.getAll()
          .subscribe(x=>this.users = x);

    }

    public handleSubmit(form: NgForm): void {
      if (form.invalid) {
        return;
      } else {
        console.log(this.user)
        console.log(this.event)
        this.service.createEvent(this.event).subscribe(() => {
          this.router.navigate(['home'])
        })
      }

    }
  }


