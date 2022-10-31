package it.contrader.controller;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService service;

    @GetMapping("/get")
    public String home() throws IOException, InterruptedException {
        return "<h2>MICROSERVIZIO 1, ID ISTANZA: " + printHostname() + "</h2>";
    }

    @GetMapping("/getall")
    public List<UserDTO> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        service.delete(id);
    }
    @PutMapping("/update")
    public UserDTO update(@RequestBody UserDTO dto){
        service.update(dto);
        return dto;
    }
    @PostMapping("/insert")
    public UserDTO insert (@RequestBody @Valid UserDTO dto) {
        service.insert(dto);
        return dto;
    }
    @GetMapping("/read")
    public UserDTO read(int id) {
        return service.read(id);
    }

    public static String printHostname() throws IOException, InterruptedException {
        String cmd = "hostname";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        line = buf.readLine();
        return line;
    }
}


