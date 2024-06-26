package ru.edu.penzgtu.repo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.entity.Artist;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {


    Artist findByName(String name);

    List<Artist> findArtistByName(String name);












}

