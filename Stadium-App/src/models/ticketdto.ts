import { EventDTO } from "./eventdto";
import { UserDTO } from "./userdto";

export class TicketDTO {
  public id!: number;
  public purchaseDate!: Date;
  public user!: UserDTO;
  public event!: EventDTO;
constructor() {}
}
