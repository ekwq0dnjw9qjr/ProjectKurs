package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Schema(description = "Информация о критике")
public class CriticDto {

    @JsonProperty("id")
    @Schema(description = "ID критика в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Имя критика может содержать только буквы")
    @Schema(description = "Имя критика", example = "Беренсон")
    private String name;

    @JsonProperty("age")
    @Positive(message = "Возраст должен быть положительным числом")
    @Schema(description = "Возраст критика", example = "33")
    private Long age;

    @JsonProperty("region")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Регион критика может содержать только буквы")
    @Schema(description = "Регион критика", example = "Гамбург")
    private String region;

    @JsonProperty("specialization")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$",
            message = "Специализация критика  может содержать только буквы")
    @Schema(description = "Специализация  критика",example = "Графика")
    private String specialization;

    @JsonProperty("dateAndTime")
    @Schema(description = "Дата и время добавления критика в БД")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;


    @JsonProperty("pictures")
    @Size(min = 0,max = 77,
            message = "Количество картин должно быть от 0 до 44")
    @Schema(description = "  Картины которые оценил критик")
    private List<String> pictures;


}
