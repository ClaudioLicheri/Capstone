package it.contrader.dao;

import it.contrader.model.Favourites;
import it.contrader.model.Tickets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FavouriteRepository extends CrudRepository<Favourites, Integer> {

    List<Favourites> getAllByUserId(int userID);
}
