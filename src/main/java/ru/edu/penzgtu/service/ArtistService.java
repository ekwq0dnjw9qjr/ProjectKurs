package ru.edu.penzgtu.service;

import ru.edu.penzgtu.service.mapper.ArtistMapper;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.entity.Artist;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.ArtistRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

 // методы для выполнения операций над сущностью "Author"
@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository; // создание репозитория  для выполнения операций над сущностью
    private final ArtistMapper artistMapper;

    public List<ArtistDto> findAllArtist(){ // метод для получения списка всех авторов из базы данных.
        return artistMapper.toListDto(artistRepository.findAll()); // использует метод findAll() репозитория чтобы извлечь все записи и
                                                                  // преобразовать их в список DTO с помощью authorMapper.
    }

    public ArtistDto findArtistById(Long id) throws PenzGtuException { // метод для поиска автора по заданному id. Используется метод findById()  для поиска автора по id.
                                                                      // если автор не найден, выбрасывается исключение типа PenzGtuException.
        Artist artist = artistRepository.findById(id)
                .orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Художник с id " + id + " не найден"));
        return artistMapper.toDto(artist); // если автор был найден, метод возвращает объект AuthorDto, содержащий информацию об авторе, иначе будет выброшено исключение.
    }

    public void saveArtist(ArtistDto artistDto){ //выполняет операцию сохранения  в бд.
        Artist artist = artistMapper.toEntity(artistDto); //
        artistRepository.save(artist); // сохранение объекта в бд
    }

    public void updateArtist(ArtistDto newArtist) { // обновление данных в бд
        Artist oldArtist = artistRepository.findById(newArtist.getId()) //поиск автора в бд по id, переданному в объекте newAuthor. Если автор с таким id не найден, вызывается исключение RuntimeException.
                // иначе найденный автор сохраняется в переменной oldAuthor.
                .orElseThrow(() ->new RuntimeException("Artist not found"));
        oldArtist.setName(newArtist.getName()); // имя найденного автора обновляется новым именем, переданным в объекте newAuthor
        artistRepository.save(oldArtist);

    }

    // удаления автора из бд по его id
    public void deleteArtistById(Long id ) {
        artistRepository.deleteById(id);
    }

}
