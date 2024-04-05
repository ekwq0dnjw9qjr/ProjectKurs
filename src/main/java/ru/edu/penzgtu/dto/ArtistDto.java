package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

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
    @Schema(description = "Имя художника", example = "Винсент Ван Гог")
    private String name;

    @JsonProperty("pictures")
    @Schema(description = "Названия картин художника")
    private List<String> pictures;
}
