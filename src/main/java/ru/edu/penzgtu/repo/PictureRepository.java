package ru.edu.penzgtu.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Gallery;
import ru.edu.penzgtu.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long>{
    Picture findByName(String name);


    List<Picture> findPictureByName(String name);


}