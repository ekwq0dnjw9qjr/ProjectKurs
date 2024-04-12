package ru.edu.penzgtu.service.mapper;

 import lombok.RequiredArgsConstructor;
 import org.springframework.stereotype.Service;
 import ru.edu.penzgtu.dto.ArtistDto;
 import ru.edu.penzgtu.entity.Artist;
 import ru.edu.penzgtu.entity.Picture;
 import ru.edu.penzgtu.repo.PictureRepository;

 import java.time.ZoneId;
 import java.util.Collections;
 import java.util.List;

 @Service
 @RequiredArgsConstructor
 public class ArtistMapper {
 private final PictureRepository pictureRepository;


 public List<ArtistDto> toListDto(List<Artist> artists) {
 return artists.stream().map(this::toDto).toList();
 }

    public ArtistDto toDto(Artist artist) {
    return ArtistDto.builder()
            .id(artist.getId())
            .name(artist.getName())
            .country(artist.getCountry())
            .style(artist.getStyle())
            .quote(artist.getQuote())
            .localDateTime(artist.getLocalDateTime())
        .pictures(artist.getPictures().stream()
        .map(Picture::getName)
        .toList())
            .build();
 }

     public Artist toEntity(ArtistDto artistDto) {
     Artist artist = new Artist();

     artist.setId(artistDto.getId());
     artist.setName(artistDto.getName());
     artist.setCountry(artistDto.getCountry());
     artist.setLocalDateTime(artistDto.getLocalDateTime());
     artist.setStyle(artistDto.getStyle());
     artist.setQuote(artistDto.getQuote());
     artist.setPictures((Collections.singletonList
             (pictureRepository.findByName(String.valueOf(artistDto.getPictures().stream().toList())))));

     return artist;
  }
 }