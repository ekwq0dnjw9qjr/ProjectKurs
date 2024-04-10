package ru.edu.penzgtu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.penzgtu.entity.Critic;

public interface CriticRepository extends JpaRepository<Critic,Long> {

    Critic findByName(String name);

}
