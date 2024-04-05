package ru.edu.penzgtu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import ru.edu.penzgtu.baseresponse.BaseResponseService;
import ru.edu.penzgtu.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.dto.ArtistDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.service.ArtistService;

import java.util.List;
@Validated
@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
@Tag(name = "Художники",description = "Операции над художниками")
public class ArtistController {
    private final ArtistService artistService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех художников", description = "Позволяет выгрузить всех художников из БД"
    )

    @GetMapping
    public ResponseWrapper<List<ArtistDto>> findAll(){
        return baseResponseService.wrapSuccessResponse(artistService.findAllArtist());
    }

    @Operation(
            summary = "Получение художника по ID", description = "Позволяет выгрузить одного художника по ID из БД"
    )

    @GetMapping("/artist/{id}")
    public ResponseWrapper<ArtistDto> getById(@PathVariable @Min(0) Long id) throws PenzGtuException {
        return baseResponseService.wrapSuccessResponse(artistService.findArtistById(id));
    }

    @Operation(
            summary = "Создать художника", description = "Позволяет создать новую запись о художнике в БД"
    )

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createArtist(@RequestBody @Valid ArtistDto artist){
        artistService.saveArtist(artist);
    }

    @Operation(
            summary = "Обновить данные о художнике", description = "Позволяет обновить информацию о художнике в БД"
    )

    @PutMapping("/artist/")
    public void updateArtist(@RequestBody  @Valid ArtistDto artist) {
        artistService.updateArtist(artist);
    }

    @Operation(
            summary = "Удалить художника по ID", description = "Позволяеть удалить художника по ID из БД"
    )

    @DeleteMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable @Min(0) Long id) {
        artistService.deleteArtistById(id);
    }


 }
