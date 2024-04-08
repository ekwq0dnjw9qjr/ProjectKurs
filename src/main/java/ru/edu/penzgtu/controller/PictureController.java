package ru.edu.penzgtu.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import ru.edu.penzgtu.baseresponse.BaseResponseService;
import ru.edu.penzgtu.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.dto.PictureDto;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.service.PictureService;

import java.util.List;
@Validated
@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
@Tag(name = "Картины",description = "Операции над картинами")
public class PictureController {
    private final PictureService pictureService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех картин", description = "Позволяет выгрузить все картины из БД")
    @GetMapping
    public ResponseWrapper<List<PictureDto>> findAllPicture() {
        return baseResponseService.wrapSuccessResponse(pictureService.findAllPicture());
    }
    @Operation(
            summary = "Получение картины по ID", description = "Позволяет выгрузить одну картину по ID из БД")
    @GetMapping("/picture/{id}")
    public ResponseWrapper<PictureDto> getPictureById(@PathVariable @Min(0) Long id)  {
        return baseResponseService.wrapSuccessResponse(pictureService.findPictureById(id));
    }
    @Operation(
            summary = "Создать картину", description = "Позволяет создать новую запись о картине  в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  createPicture(@RequestBody @Valid PictureDto picture) {
        pictureService.savePicture(picture);
    }
    @Operation(
            summary = "Обновить данные о картине ", description = "Позволяет обновить информацию о картине в БД")
    @PutMapping("/picture/")
    public void updatePicture( @RequestBody @Valid PictureDto picture ) {
        pictureService.updatePicture(picture);
    }

    @Operation(
            summary = "Удалить картину по ID ", description = "Позволяет удалить картину по ID из БД")
    @DeleteMapping("/picture/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePicture(@PathVariable @Min(0) Long id) {
        pictureService.deletePictureById(id);
    }}
