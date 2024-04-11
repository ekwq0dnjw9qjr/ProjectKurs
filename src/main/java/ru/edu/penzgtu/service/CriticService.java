package ru.edu.penzgtu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.dto.CriticDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.entity.Critic;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.ArtistRepository;
import ru.edu.penzgtu.repo.CriticRepository;
import ru.edu.penzgtu.service.mapper.ArtistMapper;
import ru.edu.penzgtu.service.mapper.CriticMapper;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CriticService {
    private final CriticRepository criticRepository;
    private final CriticMapper criticMapper;

    public List<CriticDto> findAllCritics(){
        return criticMapper.toListDto(criticRepository.findAll());
    }
    public CriticDto findCriticById(Long id)  {
        Critic critic = criticRepository.findById(id)
                .orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Критик с id " + id + " не найден"));
        return criticMapper.toDto(critic);
    }

    public List<CriticDto> findCriticByName(String name) {
        List<Critic> critics = criticRepository.findCriticByName(name);
        return criticMapper.toListDto(critics);
    }

    public List<CriticDto> findCriticByRegion(String region) {
        return criticRepository.findByRegion(region);
    }
    public void saveCritic(CriticDto criticDto){
        Critic critic = criticMapper.toEntity(criticDto);
        critic.setLocalDateTime(LocalDateTime.now());
        criticRepository.save(critic);
    }


    public void updateCritic(CriticDto newCritic) {
        Critic oldCritic = criticRepository.findById(newCritic.getId())
                .orElseThrow(() ->new PenzGtuException(ErrorType.NOT_FOUND,"Критик не найден"));
        oldCritic.setName(newCritic.getName());
        oldCritic.setSpecialization(newCritic.getSpecialization());
        oldCritic.setAge(newCritic.getAge());
        oldCritic.setRegion(newCritic.getRegion());
        criticRepository.save(oldCritic);
    }
    public void deleteCriticById(Long id ) {
        criticRepository.deleteById(id);
    }

}


