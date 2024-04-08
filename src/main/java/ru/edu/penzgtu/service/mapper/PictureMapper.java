package ru.edu.penzgtu.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Picture;
import ru.edu.penzgtu.repo.ArtistRepository;
import ru.edu.penzgtu.repo.GalleryRepository;


import java.util.List;
@RequiredArgsConstructor
@Service
public class PictureMapper {
    private final ArtistRepository artistRepository;
    private final GalleryRepository galleryRepository;

    public List<PictureDto> toListDto(List<Picture> pictures) {
        return pictures.stream().map(this::toDto).toList();
    }

    public PictureDto toDto(Picture picture) {
       return PictureDto.builder()
                .id(picture.getId())
                .name(picture.getName())
                .artistName(picture.getArtist().getName())
                .galleryName(picture.getGallery().getName())
                .build();
    }

    public Picture toEntity(PictureDto pictureDto) {
        Picture picture = new Picture();

        picture.setId(pictureDto.getId());
        picture.setName(pictureDto.getName());
        picture.setArtist(artistRepository.findByName(pictureDto.getArtistName()));
        picture.setGallery(galleryRepository.findByName(pictureDto.getGalleryName()));
        // Необходимо также установить связь с художником, если у вас есть информация о художнике в DTO
        // Это можно сделать, если вы получаете художника из базы данных или как-то иначе

        return picture;
    }
}
