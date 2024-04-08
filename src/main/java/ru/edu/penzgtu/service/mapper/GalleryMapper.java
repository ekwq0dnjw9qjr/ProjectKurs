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
                .pictures(gallery.getPictures().stream()
                        .map(Picture::getName)
                        .toList())
                .build();
    }

    public Gallery toEntity(GalleryDto galleryDto) {
        Gallery gallery = new Gallery();

        gallery.setId(galleryDto.getId());
        gallery.setName(galleryDto.getName());
        gallery.setPictures((Collections.singletonList(pictureRepository.findByName(String.valueOf(galleryDto.getPictures().stream().toList())))));

        return gallery;
    }
}
