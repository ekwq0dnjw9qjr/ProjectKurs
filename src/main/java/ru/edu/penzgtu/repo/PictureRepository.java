package ru.edu.penzgtu.repo;

import ru.edu.penzgtu.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PictureRepository extends JpaRepository<Picture, Long>{
}