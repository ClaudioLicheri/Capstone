package it.contrader.controller;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.exceptions.UserNotFoundException;
import it.contrader.model.JwtRequest;
import it.contrader.model.JwtResponse;
import it.contrader.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.contrader.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.util.JWTUtility;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @Autowired
    private UserService service;

    @GetMapping("/get")
    public String home() throws IOException, InterruptedException {
        return "<h2>MICROSERVIZIO 2, ID ISTANZA: " + printHostname() + "</h2>";
    }

    @PostMapping("/insert")
    public UserDTO insert (@RequestBody @Valid UserDTO dto) {
        service.insert(dto);
        return dto;
    }
    //POST React a UserDTO
    @PostMapping(value = "/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO) throws UserNotFoundException {
        return service.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
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

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody LoginDTO loginDTO) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(loginDTO.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}


