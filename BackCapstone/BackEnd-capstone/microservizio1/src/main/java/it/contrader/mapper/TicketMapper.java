package it.contrader.mapper;

import it.contrader.model.Tickets;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import it.contrader.dto.TicketDTO;

import java.util.List;

@Mapper
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    Tickets toEntity (TicketDTO ticketDTO);
    TicketDTO toDTO (Tickets ticket);
    List<Tickets> toEntityList(Iterable<TicketDTO> listDTO);
    List<TicketDTO> toDTOList (Iterable<Tickets> EntityList);

}
