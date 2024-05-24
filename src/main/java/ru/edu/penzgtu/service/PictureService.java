package ru.edu.penzgtu.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.entity.Picture;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.ArtistRepository;
import ru.edu.penzgtu.repo.CriticRepository;
import ru.edu.penzgtu.repo.GalleryRepository;
import ru.edu.penzgtu.repo.PictureRepository;
import ru.edu.penzgtu.service.mapper.PictureMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;
    private final ArtistRepository artistRepository;
    private final CriticRepository criticRepository;
    private final GalleryRepository galleryRepository;

    public List<PictureDto> findAllPicture() {
        log.info("Найдены все существующие картины в БД");
        return pictureMapper.toListDto(pictureRepository.findAll());
    }

    public PictureDto findPictureById( Long id) {
        log.info("Найдена картина по id: " + id);
        Picture picture = pictureRepository.findById(id)
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND, "Картина с id " + id + " не найдена"));
        return pictureMapper.toDto(picture);
    }

    public List<PictureDto> findPictureByName( String name) {
        log.info("Найдены картины по имени: " + name);
        List<Picture> pictures = pictureRepository.findPictureByName(name);
        return pictureMapper.toListDto(pictures);
    }



    public void savePicture( PictureDto pictureDto) {
        log.info("Картина сохранена");
        Picture picture = pictureMapper.toEntity(pictureDto);
        picture.setLocalDateTime(LocalDateTime.now());
        picture.setArtist(artistRepository.findByName(pictureDto.getArtistName()));
        picture.setGallery(galleryRepository.findByName(pictureDto.getGalleryName()));
        picture.setCritic(criticRepository.findByName(pictureDto.getCriticName()));

        pictureRepository.save(picture);
    }

    public void updatePicture( PictureDto newPicture) {
        log.info("Данные о картине были обновлены");
        Picture oldPicture = pictureRepository.findById(newPicture.getId())
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND, "Картина не найдена "));
        oldPicture.setName(newPicture.getName());
        oldPicture.setTechnique(newPicture.getTechnique());
        oldPicture.setGenre(newPicture.getGenre());
        oldPicture.setPrice(newPicture.getPrice());
        pictureRepository.save(oldPicture);
    }

    public void deletePictureById( Long id) {
        log.info("Удалена картины с id: " + id);
        pictureRepository.deleteById(id);
    }
}
