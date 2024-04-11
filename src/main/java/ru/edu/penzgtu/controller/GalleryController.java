package ru.edu.penzgtu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.baseresponse.BaseResponseService;
import ru.edu.penzgtu.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.dto.ArtistDto;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.service.ArtistService;
import ru.edu.penzgtu.service.GalleryService;
import ru.edu.penzgtu.service.PictureService;

import java.util.List;
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/galleries")
@Tag(name = "Галереи",description = "Операции над галереями")
public class GalleryController {
    private final GalleryService galleryService;
    private final PictureService pictureService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех галерей", description = "Позволяет выгрузить все галереи из БД"
    )
    @GetMapping
    public ResponseWrapper<List<GalleryDto>> findAll(){
        return baseResponseService.wrapSuccessResponse(galleryService.findAllGalleries());
    }


    @Operation(
            summary = "Получение галереи по ID", description = "Позволяет выгрузить одну галерею по ID из БД"
    )
    @GetMapping("/gallery/{id}")
    public ResponseWrapper<GalleryDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(galleryService.findById(id));
    }

    @Operation(
            summary = "Получение галереи по названию", description = "Позволяет найти галерею по названию из БД"
    )
    @GetMapping("/gallery/byName")
    public ResponseWrapper<List<GalleryDto>> getByName(@RequestParam String name) {
        return baseResponseService.wrapSuccessResponse(galleryService.findGalleryByName(name));
    }

    @Operation(
            summary = "Получение галереи по городу", description = "Позволяет найти галерею по городу в БД"
    )
    @GetMapping("/gallery/byCity")
    public ResponseWrapper<List<GalleryDto>> getByCity(String city) {
        return baseResponseService.wrapSuccessResponse(galleryService.findGalleryByCity(city));
    }


    @Operation(
            summary = "Создать галерею", description = "Позволяет создать новую запись о галереи в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGallery(@RequestBody @Valid GalleryDto gallery){
        galleryService.saveGallery(gallery);
    }
    @Operation(
            summary = "Обновить данные о галиреи", description = "Позволяет обновить информацию о галереи в БД"
    )
    @Transactional
    @PutMapping("/gallery/")
    public void updateGallery(@RequestBody  @Valid GalleryDto gallery) {

        galleryService.updateGallery(gallery);
    }


    @Operation(
            summary = "Удалить галерею по ID", description = "Позволяет удалить галереи по ID из БД"
    )
    @DeleteMapping("/gallery/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGallery(@PathVariable @Min(0) Long id) {
        galleryService.deleteGalleryById(id);
    }
}
