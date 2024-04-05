package ru.edu.penzgtu.repo;
import ru.edu.penzgtu.entity.Artist;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}

