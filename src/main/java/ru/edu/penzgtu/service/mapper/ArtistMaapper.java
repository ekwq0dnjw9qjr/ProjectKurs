package ru.edu.penzgtu.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.entity.Artist;

@Mapper
public interface ArtistMaapper {
    ArtistMaapper INSTANCE = Mappers.getMapper(ArtistMaapper.class);
    ArtistDto toDTO(Artist artist);
}
