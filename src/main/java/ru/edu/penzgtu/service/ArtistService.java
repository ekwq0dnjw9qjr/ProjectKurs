package ru.edu.penzgtu.service;

import jakarta.transaction.Transactional;
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
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;
    @Transactional
    public List<ArtistDto> findAllArtist(){
        return artistMapper.toListDto(artistRepository.findAll());
    }


    public ArtistDto findArtistById(Long id)  {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Художник с id " + id + " не найден"));
        return artistMapper.toDto(artist);
    }

    public List<ArtistDto> findArtistByName(String name) {
        List<Artist> artists = artistRepository.findArtistByName(name);
        return artistMapper.toListDto(artists);
    }

    public List<ArtistDto> findByCountry(String country) {
        return artistRepository.findByCountry(country);

    }
    public void saveArtist(ArtistDto artistDto){
        Artist artist = artistMapper.toEntity(artistDto);
        artist.setLocalDateTime(LocalDateTime.now());
        artistRepository.save(artist);
    }
    public void updateArtist(ArtistDto newArtist) {
        Artist oldArtist = artistRepository.findById(newArtist.getId())
                .orElseThrow(() ->new PenzGtuException(ErrorType.NOT_FOUND,"Художник не найден"));
        oldArtist.setName(newArtist.getName());
        oldArtist.setCountry(newArtist.getCountry());
        oldArtist.setStyle(newArtist.getStyle());
        oldArtist.setQuote(newArtist.getQuote());
        artistRepository.save(oldArtist);
    }
    public void deleteArtistById(Long id ) {
        artistRepository.deleteById(id);
    }

}
