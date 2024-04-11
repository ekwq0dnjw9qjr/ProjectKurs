package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.entity.Picture;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Schema(description = "Информация о галереи")
public class GalleryDto {


    @JsonProperty("id")
    @Schema(description = "ID галереи в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @Schema(description = "Название галери в БД", example = "Музей Ван Гога")
    @NotBlank
    private String name;

    @JsonProperty("country")
    @Schema(description = "Страна в которой находится галерея", example = "Германия")
    @NotBlank
    private String country;

    @JsonProperty("city")
    @Schema(description = "Город в котором находится галерея", example = "Берлин")
    @NotBlank
    private String city;

    @JsonProperty("street")
    @Schema(description = "Улица на которой находится галерея", example = "Фридрихштрассе")
    @NotBlank
    private String street;

    @JsonProperty("dateAndTime")
    @Schema(description = "Дата и время создания галери в БД")
    @NotBlank
    private LocalDateTime localDateTime;


    @JsonProperty("pictures")
    @Schema(description = "Картины в галереи")
    private List<String> pictures;

    public GalleryDto(String name,String country,List<String> pictures) {
        this.name = name;
        this.country = country;
        this.pictures = pictures;
    }
    public GalleryDto() {

    }
    public GalleryDto(String name) {
        this.name = name;
    }
    public  GalleryDto(Long id, String name, String country, List<String> pictures) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.pictures = pictures;
    }
    public  GalleryDto(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    public GalleryDto(Long id, String name, String country,String city,
                     String street, LocalDateTime localDateTime,List<String> pictures) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.pictures = pictures;
        this.localDateTime = localDateTime;
        this.city = city;
        this.street = street;
    }

    public  GalleryDto(Long id, String name, String country, String city,
                       String street, LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.localDateTime = localDateTime;
    }


}
