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
    public void saveArtist(ArtistDto artistDto){
        Artist artist = artistMapper.toEntity(artistDto);
        artistRepository.save(artist);
    }

    public void updateArtist(ArtistDto newArtist) {
        Artist oldArtist = artistRepository.findById(newArtist.getId())
                .orElseThrow(() ->new PenzGtuException(ErrorType.NOT_FOUND,"Художник не найден"));
        oldArtist.setName(newArtist.getName());
        artistRepository.save(oldArtist);
    }
    public void deleteArtistById(Long id ) {
        artistRepository.deleteById(id);
    }

}
