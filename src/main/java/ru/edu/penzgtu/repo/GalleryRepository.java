package ru.edu.penzgtu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.entity.Gallery;
import ru.edu.penzgtu.entity.Picture;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    Gallery findByName(String name);
}