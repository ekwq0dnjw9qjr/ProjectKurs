package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonProperty("country")
    @NotBlank
    @Schema(description = "Страна художника",example = "Германия")
    private String country;

    @JsonProperty("pictures")
    @Schema(description = "Названия картин художника")
    private List<String> pictures;



    public ArtistDto(String name,String country,List<String> pictures) {
        this.name = name;
        this.country = country;
        this.pictures = pictures;
    }





    public ArtistDto() {

    }



    public  ArtistDto(Long id, String name, String country, List<String> pictures) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.pictures = pictures;
    }

    public  ArtistDto(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }



}
