package it.contrader.controller;
import it.contrader.exceptions.GenericException;
import it.contrader.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.contrader.dto.TicketDTO;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;
    HttpServletRequest request;

    @GetMapping("/getall")
    public List<TicketDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/getmine")
    public List<TicketDTO> getMine(int id){
        return service.getAllByUserId(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        service.delete(id);
    }

    @PutMapping("/update")
    public TicketDTO update(@RequestBody TicketDTO dto){
        service.update(dto);
        return dto;
    }

    @PostMapping("/insert")
    public TicketDTO insert (@RequestBody TicketDTO dto) {
        service.insert(dto);
        return dto;
    }

    @GetMapping("/read")
    public TicketDTO read(int id) {
        return service.read(id);
    }

    @PostMapping("/buyticket")
    private void buyTicket (@RequestBody TicketDTO ticketDTO) throws GenericException {
        service.buyTicket(ticketDTO.getUser(),ticketDTO.getEvent());
    }

    @DeleteMapping("/deleteticket")
    public void deleteTicket(@RequestParam("id") int id) {

        service.addSeat(id);
        service.delete(id);

    }

}
