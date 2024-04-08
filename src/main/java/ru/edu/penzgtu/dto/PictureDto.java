package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Информация о картине")
public class PictureDto {

    @JsonProperty("id")
    @Schema(description = "ID картины в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Название картины", example = "Скорбь")
    private String name;

    @JsonProperty("artist")
    @Schema(description = "Имя художника картины")
    private String artistName;

    @JsonProperty("gallery")
    @Schema(description = "Галерея где находиться картина")
    private String galleryName;
}
