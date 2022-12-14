package it.contrader.dao;

import it.contrader.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<Users, Integer>{

}
