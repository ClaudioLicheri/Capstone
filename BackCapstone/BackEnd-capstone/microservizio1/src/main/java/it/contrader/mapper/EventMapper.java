package it.contrader.mapper;

import it.contrader.dto.EventDTO;
import it.contrader.model.Events;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EventMapper {
        EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

        Events toEntity (EventDTO eventDTO);
        EventDTO toDTO (Events event);

        List<Events> toEntityList(Iterable<EventDTO> listDTO);
        List<EventDTO> toDTOList(Iterable<Events> EntityList);

}
