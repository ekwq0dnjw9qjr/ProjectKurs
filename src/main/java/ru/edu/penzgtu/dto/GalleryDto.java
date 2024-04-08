package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.entity.Picture;

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

    @JsonProperty("pictures")
    @Schema(description = "Картины в галереи")
    private List<String> pictures;

}
