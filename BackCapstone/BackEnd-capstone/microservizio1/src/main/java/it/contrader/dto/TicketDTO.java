package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.Events;
import it.contrader.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    public class TicketDTO {
        private int id;

        private Events event;

        private Users user;

        private LocalDate purchaseDate = LocalDate.now();
    }

