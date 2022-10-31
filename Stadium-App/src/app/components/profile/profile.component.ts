import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/models/userdto';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  constructor() { }

  user!:UserDTO;

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('currentUser') as string);
  }

}
