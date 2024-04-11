package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
    @Schema(description = "Имя художника", example = "Винсент Ван Гог")
    private String name;

    @JsonProperty("country")
    @NotBlank
    @Schema(description = "Страна художника",example = "Германия")
    private String country;


    @JsonProperty("style")
    @Schema(description = "Стиль художника", example = "Постимпрессионизм")
    private String style;

    @JsonProperty("quote")
    @Schema(description = "Цитата художника", example = "Перед лицом великой цели никакие жертвы не покажутся " +
            "слишком большими")
    private String quote;

    @JsonProperty("dateAndTime")
    @Schema(description = "Дата и время создания художника в БД")
    private LocalDateTime localDateTime;

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
    public ArtistDto(String name) {
        this.name = name;
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
    public ArtistDto(Long id, String name, String country,String style,String quote,
                     LocalDateTime localDateTime,List<String> pictures) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.pictures = pictures;
        this.localDateTime = localDateTime;
        this.style = style;
        this.quote = quote;
    }

    public ArtistDto(Long id, String name, String country,String style,String quote,
                     LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.localDateTime = localDateTime;
        this.style = style;
        this.quote = quote;
    }



}
