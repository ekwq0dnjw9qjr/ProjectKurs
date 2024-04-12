package ru.edu.penzgtu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.baseresponse.BaseResponseService;
import ru.edu.penzgtu.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.dto.CriticDto;
import ru.edu.penzgtu.dto.GalleryDto;
import ru.edu.penzgtu.dto.PictureDto;
import ru.edu.penzgtu.service.CriticService;
import ru.edu.penzgtu.service.GalleryService;
import ru.edu.penzgtu.service.PictureService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/critics")
@RequiredArgsConstructor
@Tag(name = "Критики", description = "Операции над критиками")
public class CriticController {

    private final CriticService criticService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех критиков",
            description = "Позволяет выгрузить всех критиков из БД"
    )

    @GetMapping
    public ResponseWrapper<List<CriticDto>> findAll(){
        return baseResponseService.wrapSuccessResponse(criticService.findAllCritics());
    }

    @Operation(
            summary = "Получение критика по ID",
            description = "Позволяет выгрузить одного критика по ID из БД"
    )
    @GetMapping("/critic/{id}")
    public ResponseWrapper<CriticDto> getById(@PathVariable @Min(0) Long id)  {
        return baseResponseService.wrapSuccessResponse(criticService.findCriticById(id));
    }

    @Operation(
            summary = "Найти критика по имени",
            description = "Позволяет найти критика по имени в БД"
    )
    @GetMapping("/critic/byName")
    public ResponseWrapper<List<CriticDto>> getByName(@RequestParam String name) {
        return baseResponseService.wrapSuccessResponse(criticService.findCriticByName(name));
    }

    @Operation(
            summary = "Найти критика по региону",
            description = "Позволяет найти критика по региону в БД"
    )
    @GetMapping("/critic/byRegion")
    public ResponseWrapper<List<CriticDto>> getByRegion(@RequestParam String region) {
        return baseResponseService.wrapSuccessResponse(criticService.findCriticByRegion(region));
    }

    @Operation(
            summary = "Создать критика",
            description = "Позволяет создать новую запись о критике в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCritic(@RequestBody @Valid CriticDto critic){
        criticService.saveCritic(critic);
    }


    @Operation(
            summary = "Обновить данные о критике",
            description = "Позволяет обновить информацию о критике в БД"
    )
    @Transactional
    @PutMapping("/critic/")
    public void updateCritic(@RequestBody  @Valid CriticDto critic) {
        criticService.updateCritic(critic);
    }

    @Operation(
            summary = "Удалить критика по ID",
            description = "Позволяет удалить критика по ID из БД"
    )
    @DeleteMapping("/critic/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCritic(@PathVariable @Min(0) Long id) {
        criticService.deleteCriticById(id);
    }
}



