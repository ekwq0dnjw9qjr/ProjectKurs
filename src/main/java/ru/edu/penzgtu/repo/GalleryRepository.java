package ru.edu.penzgtu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.dto.CriticDto;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.entity.Critic;
import ru.edu.penzgtu.entity.Gallery;
import ru.edu.penzgtu.entity.Picture;

import java.util.List;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    Gallery findByName(String name);


    List<Gallery> findGalleryByName(String name);


}