package it.contrader.service;

import it.contrader.dao.EventRepository;
import it.contrader.dto.EventDTO;
import it.contrader.exceptions.GenericException;
import it.contrader.mapper.EventMapper;
import it.contrader.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class EventService {

    @Autowired
    protected CrudRepository<Events,Integer> repository;

    @Autowired
    EventRepository eventRepository;

    EventMapper eventMapper = EventMapper.INSTANCE;

    public EventDTO insert(EventDTO dto) {
        return eventMapper.toDTO(repository.save(eventMapper.toEntity(dto)));
    }

    public List<EventDTO> getAll() {
        return eventMapper.toDTOList(repository.findAll());
    }

    public EventDTO read(int id) {
        return eventMapper.toDTO(repository.findById(id).get());
    }

    public EventDTO update(EventDTO dto)
    {
        return eventMapper.toDTO(repository.save(eventMapper.toEntity(dto)));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<EventDTO> getAllByUserId(int id) throws GenericException {
        List <EventDTO> resultList = eventMapper.toDTOList(eventRepository.getAllByUserId(id));
        if (resultList.isEmpty()){
            throw new GenericException("Utente non trovato con questo id : "+id);
        }
        else {
            return resultList;
        }
    }
    public List<EventDTO> findAllByOrderByEventDate(){
        return eventMapper.toDTOList(eventRepository.findAllByOrderByEventDateAsc());
    }
}
