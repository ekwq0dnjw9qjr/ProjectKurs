package ru.edu.penzgtu.service;

import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.entity.Picture;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.PictureRepository;
import ru.edu.penzgtu.service.mapper.PictureMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;

    public List<PictureDto> findAllPicture(){
        return pictureMapper.toListDto(pictureRepository.findAll());
    }

    public PictureDto findPictureById(Long id ) {
        Picture picture = pictureRepository.findById(id)
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Картина с id " + id + " не найдена"));
        return pictureMapper.toDto(picture);
    }

    public List<PictureDto> findPictureByName(String name) {
        List<Picture> pictures = pictureRepository.findPictureByName(name);
        return pictureMapper.toListDto(pictures);
    }

    public List<PictureDto> findPictureByGenre(String genre) {
       return pictureRepository.findByGenre(genre);
    }

    public void  savePicture(PictureDto pictureDto){
        Picture picture = pictureMapper.toEntity(pictureDto);
        picture.setLocalDateTime(LocalDateTime.now());
        pictureRepository.save(picture);
    }
    public void updatePicture(PictureDto newPicture) {
        Picture oldPicture = pictureRepository.findById(newPicture.getId())
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Картина не найдена " ));
        oldPicture.setName(newPicture.getName());
        oldPicture.setTechnique(newPicture.getTechnique());
        oldPicture.setGenre(newPicture.getGenre());
        oldPicture.setPrice(newPicture.getPrice());
        pictureRepository.save(oldPicture);
    }
    public void deletePictureById(Long id ){
        pictureRepository.deleteById(id);
    }
}