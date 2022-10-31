package it.contrader.service;

import it.contrader.dao.EventRepository;
import it.contrader.dao.FavouriteRepository;
import it.contrader.dao.TicketRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.FavouriteDTO;
import it.contrader.dto.TicketDTO;
import it.contrader.dto.UserDTO;
import it.contrader.mapper.EventMapper;
import it.contrader.mapper.FavouriteMapper;
import it.contrader.mapper.TicketMapper;
import it.contrader.mapper.UserMapper;
import it.contrader.model.Events;
import it.contrader.model.Favourites;
import it.contrader.model.Tickets;
import it.contrader.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;
@Service
public class FavouriteService {

    @Autowired
    protected CrudRepository<Favourites,Integer> repository;

    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    EventRepository eventRepository;


    FavouriteMapper favouriteMapper = FavouriteMapper.INSTANCE;
    EventMapper eventMapper = EventMapper.INSTANCE;

    public FavouriteDTO insert(FavouriteDTO dto) {
        return favouriteMapper.toDTO(repository.save(favouriteMapper.toEntity(dto)));
    }


    public List<FavouriteDTO> getAll() {
        return favouriteMapper.toDTOList(repository.findAll());
    }


    public FavouriteDTO read(int id) {
        return favouriteMapper.toDTO(repository.findById(id).get());
    }

    public FavouriteDTO update(FavouriteDTO dto)
    {
        return favouriteMapper.toDTO(repository.save(favouriteMapper.toEntity(dto)));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<FavouriteDTO> getAllByUserId(int id) {
        List<FavouriteDTO> resultList = favouriteMapper.toDTOList(favouriteRepository.getAllByUserId(id));
        return resultList;
    }


    public List<FavouriteDTO> findByUserId(int myId) {
        List<FavouriteDTO> resultList = favouriteMapper.toDTOList(favouriteRepository.getAllByUserId(myId));
        return  resultList;
    }

    public void addFavourite(Users user, Events event){
        EventDTO eventDTO = eventMapper.toDTO(event);
        eventRepository.save(eventMapper.toEntity(eventDTO));

        repository.save(favouriteMapper.toEntity(new FavouriteDTO(0,user,eventMapper.toEntity(eventDTO))));
    }

}
