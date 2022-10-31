package it.contrader.service;

import it.contrader.dao.EventRepository;
import it.contrader.dao.TicketRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.TicketDTO;
import it.contrader.exceptions.GenericException;
import it.contrader.mapper.EventMapper;
import it.contrader.model.Events;
import it.contrader.model.Tickets;
import it.contrader.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;

import it.contrader.mapper.TicketMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    protected CrudRepository<Tickets,Integer> repository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    EventRepository eventRepository;
    TicketMapper ticketMapper = TicketMapper.INSTANCE;
    EventMapper eventMapper = EventMapper.INSTANCE;


    public TicketDTO insert(TicketDTO dto) {
        return ticketMapper.toDTO(repository.save(ticketMapper.toEntity(dto)));
    }
    public List<TicketDTO> getAll() {
        return ticketMapper.toDTOList(repository.findAll());
    }
    public TicketDTO read(int id) {
        return ticketMapper.toDTO(repository.findById(id).get());
    }
    public TicketDTO update(TicketDTO dto)
    {
        return ticketMapper.toDTO(repository.save(ticketMapper.toEntity(dto)));
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<TicketDTO> getAllByUserId(int id) {
        List<TicketDTO> resultList = ticketMapper.toDTOList(ticketRepository.getAllByUserId(id));
        return resultList;
    }


    public List<TicketDTO> findByUserId(int myId) {
        List<TicketDTO> resultList = ticketMapper.toDTOList(ticketRepository.findByUserId(myId));
        return  resultList;
    }
    public void buyTicket(Users user, Events event) throws GenericException{

        EventDTO eventDTO = eventMapper.toDTO(eventRepository.getEventsById(event.getId()));
        if (eventDTO.getPlacesAvailable()>0){
            eventDTO.setPlacesAvailable(eventDTO.getPlacesAvailable()-1);
        }
        else {
            throw new GenericException("posti non disponibili");
        }

        eventRepository.save(eventMapper.toEntity(eventDTO));

        repository.save(ticketMapper.toEntity(new TicketDTO(0,eventMapper.toEntity(eventDTO),user, LocalDate.now())));
    }
    public void addSeat(int id){

        TicketDTO ticketDTO = ticketMapper.toDTO(ticketRepository.getById(id));
        EventDTO eventDTO = eventMapper.toDTO(eventRepository.getEventsById(ticketDTO.getEvent().getId()));
        eventDTO.setPlacesAvailable(eventDTO.getPlacesAvailable()+1);
        eventRepository.save(eventMapper.toEntity(eventDTO));
    }
}
