package it.contrader.service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.mapper.UserMapper;
import it.contrader.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	protected CrudRepository<Users,Integer> repository;
	@Autowired
	 UserRepository userRepository;
	UserMapper userMapper = UserMapper.INSTANCE;

	public UserDTO insert(UserDTO dto) {
		return userMapper.toDTO(repository.save(userMapper.toEntity(dto)));
	}
	public List<UserDTO> getAll() {
		return userMapper.toDTOList(repository.findAll());
	}
	public UserDTO read(int id) {
		return userMapper.toDTO(repository.findById(id).get());
	}
	public UserDTO update(UserDTO dto)
	{
		return userMapper.toDTO(repository.save(userMapper.toEntity(dto)));
	}
	public void delete(int id) {
		repository.deleteById(id);
	}

}
