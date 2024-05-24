package ru.edu.penzgtu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.dto.CriticDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Critic;

import java.util.List;

public interface CriticRepository extends JpaRepository<Critic,Long> {

    Critic findByName(String name);

    List<Critic> findCriticByName(String name);



}
