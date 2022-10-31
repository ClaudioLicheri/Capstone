import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/models/userdto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user!: UserDTO;

  constructor() { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('currentUser') as string);
  }

}
