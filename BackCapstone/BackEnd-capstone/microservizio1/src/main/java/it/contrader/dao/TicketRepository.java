package it.contrader.dao;

import it.contrader.model.Events;
import it.contrader.model.Tickets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface TicketRepository extends CrudRepository<Tickets, Integer> {

    List<Tickets> getAllByUserId(int id);
    List<Tickets> findByUserId(int userID);
    Tickets getById(int id);
}
