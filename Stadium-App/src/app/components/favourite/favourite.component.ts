import { Component, OnInit } from '@angular/core';
import { FavouriteService } from 'src/app/services/favourite.service';
import { EventDTO } from 'src/models/eventdto';
import { FavouriteDTO } from 'src/models/favouritedto';
import { UserDTO } from 'src/models/userdto';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  public user!: UserDTO;
  public event!: EventDTO[];
  public favourite!: FavouriteDTO[];

  constructor(private service: FavouriteService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser') as string);
    this.service.getAllByUserId(this.user.id).subscribe(event => {
      this.favourite = event;
      console.log(event)
    });
  }

}
