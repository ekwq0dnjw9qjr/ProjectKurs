package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@Schema(description = "Информация о художнике")
public class ArtistDto {

    @JsonProperty("id")
    @Schema(description = "ID художника в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Имя художника может содержать только буквы и пробелы")
    @Schema(description = "Имя художника", example = "Винсент Ван Гог")
    private String name;

    @JsonProperty("country")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Страна художника может содержать только буквы и пробелы")
    @Schema(description = "Страна художника",example = "Голландия")
    private String country;


    @JsonProperty("style")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Стиль художника может содержать только буквы и пробелы")
    @Schema(description = "Стиль художника", example = "Постимпрессионизм")
    private String style;

    @JsonProperty("quote")
    @NotBlank
    @Schema(description = "Цитата художника",
            example = "Одиночество достаточно большое несчастье, нечто вроде тюрьмы.")
    private String quote;

    @JsonProperty("dateAndTime")
    @Schema(description = "Дата и время добавления художника в БД")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;

    @JsonProperty("pictures")
    @Size(min = 0,max = 44,
            message = "Количество названий картин должно быть от 0 до 44")
    @Schema(description = "Названия картин художника")
    private List<String>    pictures;


}
