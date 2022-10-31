package it.contrader.dao;

import it.contrader.model.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EventRepository  extends CrudRepository<Events, Integer> {

    List<Events> getAllByUserId(int id);
    List<Events> findAllByOrderByEventDateAsc();
    Events getEventsById(int id);

}
