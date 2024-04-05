package ru.edu.penzgtu.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Picture;

import java.util.List;
@Service
public class PictureMapper {
    public List<PictureDto> toListDto(List<Picture> pictures) {
        return pictures.stream().map(this::toDto).toList();
    }

    public PictureDto toDto(Picture picture) {
        return PictureDto.builder()
                .id(picture.getId())
                .name(picture.getName())
                .artists(picture.getArtists().stream()
                        .map(Artist::getName)
                        .toList())
                .build();
    }

    public Picture toEntity(PictureDto pictureDto) {
       Picture picture = new Picture();

        picture.setId(pictureDto.getId());
        picture.setName(pictureDto.getName());

        return picture;
    }
}
