package ru.edu.penzgtu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.baseresponse.BaseResponseService;
import ru.edu.penzgtu.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.entity.Artist;
import ru.edu.penzgtu.repo.ArtistRepository;
import ru.edu.penzgtu.service.ArtistService;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
@Tag(name = "Художники", description = "Операции над художниками")
public class ArtistController {
    private final ArtistService artistService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех художников",
            description = "Позволяет выгрузить всех художников из БД"
    )
    @GetMapping
    public ResponseWrapper<List<ArtistDto>> findAllArtists() {
        return baseResponseService.wrapSuccessResponse(artistService.findAllArtist());
    }


    @Operation(
            summary = "Получение художника по ID",
            description = "Позволяет выгрузить одного художника по ID из БД"
    )
    @GetMapping("/artist/{id}")
    public ResponseWrapper<ArtistDto> getArtistById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(artistService.findArtistById(id));
    }
    @Operation(
            summary = "Получение художника по имени",
            description = "Позволяет выгрузить одного художника по имени из БД"
    )
    @GetMapping("/artist/byName")
    public ResponseWrapper <List<ArtistDto>> findArtistByName(@RequestParam String name) {
        return baseResponseService.wrapSuccessResponse(artistService.findArtistByName(name));
    }



    @Operation(
            summary = "Создать художника",
            description = "Позволяет создать новую запись о художнике в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createArtist(@RequestBody @Valid ArtistDto artist) {
        artistService.saveArtist(artist);
    }


    @Operation(
            summary = "Обновить данные о художнике",
            description = "Позволяет обновить информацию о художнике в БД"
    )
    @PutMapping("/artist/")
    public void updateArtist(@RequestBody @Valid ArtistDto artist) {
        artistService.updateArtist(artist);
    }


    @Operation(
            summary = "Удалить художника по ID",
            description = "Позволяет удалить художника по ID из БД"
    )
    @DeleteMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable @Min(0) Long id) {
        artistService.deleteArtistById(id);
    }
}
