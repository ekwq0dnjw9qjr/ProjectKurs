package ru.edu.penzgtu.service;

import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.entity.Picture;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.PictureRepository;
import ru.edu.penzgtu.service.mapper.PictureMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;

    public List<PictureDto> findAllPicture(){
        return pictureMapper.toListDto(pictureRepository.findAll());
    }

    public PictureDto findPictureById(Long id ) throws  PenzGtuException{
        Picture picture = pictureRepository.findById(id)
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Картина с id " + id + " не найдена"));
        return pictureMapper.toDto(picture);
    }

    public void  savePicture(PictureDto pictureDto){
        Picture picture = pictureMapper.toEntity(pictureDto);
        pictureRepository.save(picture);
    }

    public void updatePicture(PictureDto newPicture) {
        Picture oldPicture = pictureRepository.findById(newPicture.getId())
                .orElseThrow(() -> new RuntimeException("Picture not found with id: "));


        oldPicture.setName(newPicture.getName());

        pictureRepository.save(oldPicture);
    }

    public void deletePictureById(Long id ){
        pictureRepository.deleteById(id);
    }
}