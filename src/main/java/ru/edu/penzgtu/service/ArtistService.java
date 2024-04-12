package ru.edu.penzgtu.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.entity.Artist;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.ArtistRepository;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.service.mapper.ArtistMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;
    @Transactional
    public List<ArtistDto> findAllArtist(){
        log.info("Найдены все существующие художники в БД");
        return artistMapper.toListDto(artistRepository.findAll());
    }


    public ArtistDto findArtistById(Long id)  {
        log.info("Найден художник по id: " + id);
        Artist artist = artistRepository.findById(id)
                .orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Художник с id " + id + " не найден"));
        return artistMapper.toDto(artist);
    }


    public List<ArtistDto> findArtistByName(String name) {
        log.info("Найдены художники по имени: " + name);
        List<Artist> artists = artistRepository.findArtistByName(name);
        return artistMapper.toListDto(artists);
    }


    public List<ArtistDto> findByCountry(String country) {
        log.info("Найдены художники по стране: " + country);
        return artistRepository.findByCountry(country);
    }


    public void saveArtist(ArtistDto artistDto){
        log.info("Художник сохранен");
        Artist artist = artistMapper.toEntity(artistDto);
        artist.setLocalDateTime(LocalDateTime.now());
        artistRepository.save(artist);
    }


    public void updateArtist(ArtistDto newArtist) {
        log.info("Данные о художнике были обновлены");
        Artist oldArtist = artistRepository.findById(newArtist.getId())
                .orElseThrow(() ->new PenzGtuException(ErrorType.NOT_FOUND,"Художник не найден"));
        oldArtist.setName(newArtist.getName());
        oldArtist.setCountry(newArtist.getCountry());
        oldArtist.setStyle(newArtist.getStyle());
        oldArtist.setQuote(newArtist.getQuote());
        artistRepository.save(oldArtist);
    }


    public void deleteArtistById(Long id ) {
        log.info("Удален художник с id: " + id);
        artistRepository.deleteById(id);
    }

}
