package ru.edu.penzgtu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.CriticDto;
import ru.edu.penzgtu.entity.Critic;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.CriticRepository;
import ru.edu.penzgtu.repo.PictureRepository;
import ru.edu.penzgtu.service.mapper.CriticMapper;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class CriticService {
    private final CriticRepository criticRepository;
    private final CriticMapper criticMapper;
    private final PictureRepository pictureRepository;

    public List<CriticDto> findAllCritics(){
        log.info("Найдены все существующие критики в БД");
        return criticMapper.toListDto(criticRepository.findAll());
    }


    public CriticDto findCriticById(Long id)  {
        log.info("Найден критик по id: " + id);
        Critic critic = criticRepository.findById(id)
                .orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Критик с id " + id + " не найден"));
        return criticMapper.toDto(critic);
    }


    public List<CriticDto> findCriticByName(String name) {
        log.info("Найдены критики по имени: " + name);
        List<Critic> critics = criticRepository.findCriticByName(name);
        return criticMapper.toListDto(critics);
    }




    public void saveCritic(CriticDto criticDto){
        log.info("Критик сохранен");
        Critic critic = criticMapper.toEntity(criticDto);
        critic.setLocalDateTime(LocalDateTime.now());
        critic.setPictures((Collections.singletonList
                (pictureRepository.findByName(String.valueOf(criticDto.getPictures().stream().toList())))));
        criticRepository.save(critic);
    }


    public void updateCritic(CriticDto newCritic) {
        log.info("Данные о критике были обновлены");
        Critic oldCritic = criticRepository.findById(newCritic.getId())
                .orElseThrow(() ->new PenzGtuException(ErrorType.NOT_FOUND,"Критик не найден"));
        oldCritic.setName(newCritic.getName());
        oldCritic.setSpecialization(newCritic.getSpecialization());
        oldCritic.setAge(newCritic.getAge());
        oldCritic.setRegion(newCritic.getRegion());
        criticRepository.save(oldCritic);
    }


    public void deleteCriticById(Long id ) {
        log.info("Удален критик с id: " + id);
        criticRepository.deleteById(id);
    }

}


