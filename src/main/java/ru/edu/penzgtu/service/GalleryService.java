package ru.edu.penzgtu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.GalleryRepository;
import ru.edu.penzgtu.service.mapper.GalleryMapper;
import ru.edu.penzgtu.entity.Gallery;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;
    private final GalleryMapper galleryMapper;


    public List<GalleryDto> findAllGalleries() {
        return galleryMapper.toListDto(galleryRepository.findAll());
    }

    public GalleryDto findById(Long id) {
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Галерея с id " + id + " на найдена"));
        return galleryMapper.toDto(gallery);
    }

    public void  saveGallery (GalleryDto galleryDto) {
        Gallery gallery = galleryMapper.toEntity(galleryDto);
        galleryRepository.save(gallery);
    }

    public void updateGallery (GalleryDto newGallery) {
        Gallery oldGallery = galleryRepository.findById(newGallery.getId()).
                orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Галерея не найдена"));
        oldGallery.setName(newGallery.getName());
        galleryRepository.save(oldGallery);
    }

    public void deleteGalleryById (Long id) {
        galleryRepository.deleteById(id);
    }
}
