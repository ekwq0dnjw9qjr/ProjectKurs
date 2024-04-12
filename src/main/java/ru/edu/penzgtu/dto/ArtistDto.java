package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
    @Pattern(regexp = "[a-zA-Zа-яА-Я]+", message = "Имя художника может содержать только буквы")
    @Schema(description = "Имя художника", example = "Винсент Ван Гог")
    private String name;

    @JsonProperty("country")
    @NotBlank
    @Pattern(regexp = "[a-zA-Zа-яА-Я]+", message = "Страна художника может содержать только буквы")
    @Schema(description = "Страна художника",example = "Германия")
    private String country;


    @JsonProperty("style")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]+", message = "Стиль художника может содержать только буквы")
    @Schema(description = "Стиль художника", example = "Постимпрессионизм")
    private String style;

    @JsonProperty("quote")
    @NotBlank
    @Schema(description = "Цитата художника", example = "Перед лицом великой цели никакие жертвы не покажутся " +
            "слишком большими")
    private String quote;

    @JsonProperty("dateAndTime")
    @NotBlank
    @Schema(description = "Дата и время добавления художника в БД")
    private LocalDateTime localDateTime;

    @JsonProperty("pictures")
    @Size(min = 0,max = 44, message = "Количество названий картин должно быть от 0 до 44")
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
