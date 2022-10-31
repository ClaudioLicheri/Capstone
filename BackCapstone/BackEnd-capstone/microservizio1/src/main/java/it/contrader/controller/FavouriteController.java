package it.contrader.controller;

import it.contrader.dto.FavouriteDTO;
import it.contrader.dto.TicketDTO;
import it.contrader.service.FavouriteService;
import it.contrader.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/favourite")
public class FavouriteController {

    @Autowired
    private FavouriteService service;
    HttpServletRequest request;


    @GetMapping("/getall")
    public List<FavouriteDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/getmine")
    public List<FavouriteDTO> getMine(int id){
        return service.getAllByUserId(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        service.delete(id);
    }

    @PostMapping("/insert")
    public FavouriteDTO insert (@RequestBody FavouriteDTO dto) {
        service.insert(dto);
        return dto;
    }

    @GetMapping("/read")
    public FavouriteDTO read(int id) {
        return service.read(id);
    }

    @PostMapping("/addfavourite")
    private void addFavourite (@RequestBody FavouriteDTO favouriteDTO){
        service.addFavourite(favouriteDTO.getUser(),favouriteDTO.getEvent());
    }


}
