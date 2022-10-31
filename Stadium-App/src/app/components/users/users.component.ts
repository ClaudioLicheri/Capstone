import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { UserDTO } from 'src/models/userdto';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users!: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();
  user: string = "";

  /* edit: boolean = false; */
  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.getUsers();
    this.getLocalStorage();
  }

  getLocalStorage(){
    var user= JSON.parse(localStorage.getItem('currentUser') as string);
    console.log(user.username);
  }

  switchEdit(u: UserDTO) {
    if (u.editing == false) {
    u.editing = true;
  }else {u.editing = false; }
  }

  getUsers() {
    this.service.getAll().subscribe(users => this.users = users);
  }

  delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUsers());
  }

  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUsers());
  }

  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUsers());
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }
}
