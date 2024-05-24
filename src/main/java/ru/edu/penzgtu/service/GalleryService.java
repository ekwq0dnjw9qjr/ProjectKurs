package ru.edu.penzgtu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.GalleryRepository;
import ru.edu.penzgtu.repo.PictureRepository;
import ru.edu.penzgtu.service.mapper.GalleryMapper;
import ru.edu.penzgtu.entity.Gallery;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;
    private final GalleryMapper galleryMapper;
    private final PictureRepository pictureRepository;


    public List<GalleryDto> findAllGalleries() {
        log.info("Найдены все существующие галереи в БД");
        return galleryMapper.toListDto(galleryRepository.findAll());
    }


    public GalleryDto findGalleryById(Long id) {
        log.info("Найдена галерея по id: " + id);
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Галерея с id " + id + " на найдена"));
        return galleryMapper.toDto(gallery);
    }


    public List<GalleryDto> findGalleryByName(String name) {
        log.info("Найдены галереи по имени: " + name);
        List<Gallery> galleries = galleryRepository.findGalleryByName(name);
        return galleryMapper.toListDto(galleries);
    }





    public void  saveGallery (GalleryDto galleryDto) {
        log.info("Галерея сохранена");
        Gallery gallery = galleryMapper.toEntity(galleryDto);
        gallery.setLocalDateTime(LocalDateTime.now());
        gallery.setPictures((Collections.singletonList
                (pictureRepository.findByName(String.valueOf(galleryDto.getPictures().stream().toList())))));
        galleryRepository.save(gallery);
    }


    public void updateGallery (GalleryDto newGallery) {
        log.info("Данные о галереи были обновлены");
        Gallery oldGallery = galleryRepository.findById(newGallery.getId()).
                orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Галерея не найдена"));
        oldGallery.setName(newGallery.getName());
        oldGallery.setCountry(newGallery.getCountry());
        oldGallery.setCity(newGallery.getCity());
        oldGallery.setStreet(newGallery.getStreet());
        galleryRepository.save(oldGallery);
    }


    public void deleteGalleryById (Long id) {
        log.info("Удалена галерея с id: " + id);
        galleryRepository.deleteById(id);
    }
}
