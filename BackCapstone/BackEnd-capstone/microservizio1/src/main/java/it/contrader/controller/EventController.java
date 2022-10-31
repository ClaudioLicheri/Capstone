package it.contrader.controller;

import it.contrader.dto.EventDTO;
import it.contrader.dto.FavouriteDTO;
import it.contrader.exceptions.GenericException;
import it.contrader.service.EventService;
import it.contrader.service.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService service;
    HttpServletRequest request;

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("/getall")
    public List<EventDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/getmine")
    public List<EventDTO> getMine(int id) throws GenericException {
        return service.getAllByUserId(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        service.delete(id);
    }

    @PutMapping("/update")
    public EventDTO update(@RequestBody EventDTO dto){
        service.update(dto);
        return dto;
    }

    @PostMapping("/insert")
    public EventDTO insert (@RequestBody EventDTO dto) {
        service.insert(dto);
        return dto;
    }

    @GetMapping("/read")
    public EventDTO read(int id) {
        return service.read(id);
    }


    @GetMapping("/getallordered")
    public List<EventDTO> getAllOrdered(){
        return service.findAllByOrderByEventDate();
    }


    @GetMapping("/getallforuser")
    public List<EventDTO> getAll(@RequestParam("id")int myId){
        List<EventDTO> resultList = service.findAllByOrderByEventDate();
        checkFavourites(myId ,resultList);
        return resultList;


    }

    private void checkFavourites( int id, List<EventDTO> eventDTOList) {
        List<FavouriteDTO> FavouriteDTOList = favouriteService.getAllByUserId(id);
        for (EventDTO e : eventDTOList) {
            for (FavouriteDTO f : FavouriteDTOList) {
                if (f.getEvent().getId() == e.getId()) {
                    e.setFavourite(true);
                }
            }
        }


    }
}
