package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "Информация о картине")
public class PictureDto {

    @JsonProperty("id")
    @Schema(description = "ID картины в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Название картины", example = "Скорбь")
    private String name;


    @JsonProperty("genre")
    @NotBlank
    @Schema(description = "Жанр картины", example = "Пейзаж")
    private String genre;

    @JsonProperty("technique")
    @NotBlank
    @Schema(description = "Техника в которой выполнена картина", example = "Живопись")
    private String technique;

    @JsonProperty("price")
    @NotBlank
    @Schema(description = "Цена картины", example = "200")
    private Long price;

    @JsonProperty("dateAndTime")
    @NotBlank
    @Schema(description = "Дата и время добавления  картины в БД")
    private LocalDateTime localDateTime;


    @JsonProperty("artist")
    @Schema(description = "Имя художника картины",example = "Винсент Ван Гог")
    private String artistName;

    @JsonProperty("gallery")
    @Schema(description = "Галерея где находиться картина",example = "Музей Ван Гога")
    private String galleryName;

    @JsonProperty("critic")
    @Schema(description = "Критик который оценивают картины", example = "LenaGolovach")
    private String criticName;



    public PictureDto() {

    }
    public  PictureDto(Long id, String name, String technique, String genre,
                       Long price, LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.technique = technique;
        this.genre = genre;
        this.price = price;
        this.localDateTime = localDateTime;
    }



}
