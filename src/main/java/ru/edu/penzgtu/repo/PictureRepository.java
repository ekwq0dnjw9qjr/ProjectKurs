package ru.edu.penzgtu.repo;

import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long>{
    Picture findByName(String name);
}