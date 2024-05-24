package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Название галереи может содержать только буквы")
    private String name;


    @JsonProperty("country")
    @Schema(description = "Страна в которой находится галерея", example = "Германия")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Страна в  которой находится галерея может содержать только буквы")
    private String country;



    @JsonProperty("city")
    @Schema(description = "Город в котором находится галерея", example = "Берлин")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Город в котором находится галерея может содержать только буквы")
    private String city;



    @JsonProperty("street")
    @Schema(description = "Улица на которой находится галерея", example = "Фридрихштрассе")
    @NotBlank
    private String street;



    @JsonProperty("dateAndTime")
    @Schema(description = "Дата и время добавления галери в БД")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;



    @JsonProperty("pictures")
    @Schema(description = "Картины в галереи")
    @Size(min = 0,max = 72, message = "Количество  картин в галереи должно быть от 0 до 44")
    private List<String> pictures;




}
