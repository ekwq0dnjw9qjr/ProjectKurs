package ru.edu.penzgtu.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.dto.CriticDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Critic;
import ru.edu.penzgtu.entity.Picture;
import ru.edu.penzgtu.repo.PictureRepository;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CriticMapper {
    private final PictureRepository pictureRepository;


    public List<CriticDto> toListDto(List<Critic> critics) {
        return critics.stream().map(this::toDto).toList();
    }

    public CriticDto toDto(Critic critic) {
        return CriticDto.builder()
                .id(critic.getId())
                .name(critic.getName())
                .specialization(critic.getSpecialization())
                .age(critic.getAge())
                .region(critic.getRegion())
                .localDateTime(critic.getLocalDateTime())
                .pictures(critic.getPictures().stream()
                        .map(Picture::getName)
                        .toList())
                .build();
    }

    public Critic toEntity(CriticDto criticDto) {
        Critic critic = new Critic();

        critic.setId(criticDto.getId());
        critic.setName(criticDto.getName());
        critic.setSpecialization(criticDto.getSpecialization());
        critic.setAge(criticDto.getAge());
        critic.setRegion(criticDto.getRegion());
        critic.setLocalDateTime(criticDto.getLocalDateTime());
        critic.setPictures((Collections.singletonList
                (pictureRepository.findByName(String.valueOf(criticDto.getPictures().stream().toList())))));


        return critic;
    }

}
