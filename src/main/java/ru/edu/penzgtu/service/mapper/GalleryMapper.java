package ru.edu.penzgtu.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Gallery;
import ru.edu.penzgtu.entity.Picture;
import ru.edu.penzgtu.repo.GalleryRepository;
import ru.edu.penzgtu.repo.PictureRepository;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GalleryMapper {
    private final PictureRepository pictureRepository;

    public List<GalleryDto> toListDto(List<Gallery> galleries) {
        return galleries.stream().map(this::toDto).toList();
    }

    public GalleryDto toDto(Gallery gallery) {
        return GalleryDto.builder()
                .id(gallery.getId())
                .name(gallery.getName())
                .country(gallery.getCountry())
                .city(gallery.getCity())
                .street(gallery.getStreet())
                .localDateTime(gallery.getLocalDateTime())
                .pictures(gallery.getPictures().stream()
                        .map(Picture::getName)
                        .toList())
                .build();
    }

    public Gallery toEntity(GalleryDto galleryDto) {
        Gallery gallery = new Gallery();

        gallery.setId(galleryDto.getId());
        gallery.setName(galleryDto.getName());
        gallery.setCountry(galleryDto.getCountry());
        gallery.setCity(galleryDto.getCity());
        gallery.setStreet(galleryDto.getStreet());
        gallery.setLocalDateTime(galleryDto.getLocalDateTime());

        return gallery;
    }
}
