package it.contrader.mapper;

import it.contrader.dto.FavouriteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Favourites;
import it.contrader.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FavouriteMapper {
    FavouriteMapper INSTANCE = Mappers.getMapper(FavouriteMapper.class);

    Favourites toEntity (FavouriteDTO user);
    FavouriteDTO toDTO (Favourites user);

    List<Favourites> toEntityList(Iterable<FavouriteDTO> listDTO);
    List<FavouriteDTO> toDTOList(Iterable<Favourites> EntityList);

}
