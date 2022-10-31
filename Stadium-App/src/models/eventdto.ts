import { TicketDTO } from "./ticketdto";
import { UserDTO } from "./userdto";

export class EventDTO {
        public id!: number;
        public user!: UserDTO;
        public placesAvailable!: number;
        public name!: string;
        public eventName!: string;
        public eventDate!: Date;
        public stadiumName!: string;
        public maxCapacity!: number;
        public ticket!: TicketDTO
    constructor(

    ) {
    }
}
