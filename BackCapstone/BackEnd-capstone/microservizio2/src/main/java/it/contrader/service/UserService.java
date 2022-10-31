package it.contrader.service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.exceptions.UserNotFoundException;
import it.contrader.mapper.UserMapper;
import it.contrader.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	protected CrudRepository<Users,Integer> repository;
	@Autowired
	 UserRepository userRepository;
	UserMapper userMapper = UserMapper.INSTANCE;

	public UserDTO insert(UserDTO dto) {
		return userMapper.toDTO(repository.save(userMapper.toEntity(dto)));
	}
	//LOGIN method
	public UserDTO findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
		UserDTO loggedUser = userMapper.toDTO((userRepository).findByUsernameAndPassword(username, password));
		if(loggedUser == null){
			throw new UserNotFoundException("Utente non trovato");
		}else {
			return loggedUser;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		UserDTO loggedUser = userMapper.toDTO((userRepository).findByUsername(userName));
		return new org.springframework.security.core.userdetails.User(loggedUser.getUsername(), loggedUser.getPassword(),
				new ArrayList<>());

		//return new User("admin","password",new ArrayList<>());
	}

}
