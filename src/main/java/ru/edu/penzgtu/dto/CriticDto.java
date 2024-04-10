package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

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
    @Schema(description = "Имя критика", example = "LenaGolovach")
    private String name;

    @JsonProperty("specialization")
    @NotBlank
    @Schema(description = "Специализация  критика",example = "Графика")
    private String specialization;

    @JsonProperty("pictures")
    @Schema(description = "Отзыв критика о картинах")
    private List<String> pictures;
}
