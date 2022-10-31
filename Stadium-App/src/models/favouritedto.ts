import { UserDTO } from "./userdto";
import { EventDTO } from "./eventdto";

export class FavouriteDTO {
  public id!: number;
  public user!: UserDTO;
  public event!: EventDTO;
}
