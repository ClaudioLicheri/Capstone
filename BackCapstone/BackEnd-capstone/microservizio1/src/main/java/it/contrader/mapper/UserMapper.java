package it.contrader.mapper;

import it.contrader.dto.UserDTO;
import it.contrader.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    Users toEntity (UserDTO user);
    UserDTO toDTO (Users user);

    List<Users> toEntityList(Iterable<UserDTO> listDTO);
    List<UserDTO> toDTOList(Iterable<Users> EntityList);

}

