package ru.edu.penzgtu.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Picture;

import java.util.List;

@Service
public class ArtistMapper {

    public List<ArtistDto> toListDto(List<Artist> artists) {
        return artists.stream().map(this::toDto).toList();
    }

    public ArtistDto toDto(Artist artist) {
        return ArtistDto.builder()
                .id(artist.getId())
                .name(artist.getName())
                .pictures(artist.getPictures().stream()
                        .map(Picture::getName)
                        .toList())
                .build();
    }

    public Artist toEntity(ArtistDto artistDto) {
        Artist artist = new Artist();

        artist.setId(artistDto.getId());
        artist.setName(artistDto.getName());

        return artist;
    }
}
