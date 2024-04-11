package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
    @Schema(description = "Имя критика", example = "LenaGolovach")
    private String name;

    @JsonProperty("age")
    @NotBlank
    @Schema(description = "Возраст критика", example = "33")
    private Long age;

    @JsonProperty("region")
    @NotBlank
    @Schema(description = "Регион критика", example = "Гамбург")
    private String region;

    @JsonProperty("specialization")
    @NotBlank
    @Schema(description = "Специализация  критика",example = "Графика")
    private String specialization;

    @JsonProperty("dateAndTime")
    @NotBlank
    @Schema(description = "Дата и время добавления критика в БД")
    private LocalDateTime localDateTime;


    @JsonProperty("pictures")
    @Schema(description = "Отзыв критика о картинах")
    private List<String> pictures;



    public CriticDto(String name,String region,List<String> pictures) {
        this.name = name;
        this.region = region;
        this.pictures = pictures;
    }
    public CriticDto() {

    }
    public CriticDto(String name) {
        this.name = name;
    }
    public  CriticDto(Long id, String name, String region, List<String> pictures) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.pictures = pictures;
    }
    public  CriticDto(Long id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
    public CriticDto(Long id, String name, Long age,String region,
                     String specialization, LocalDateTime localDateTime,List<String> pictures) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pictures = pictures;
        this.localDateTime = localDateTime;
        this.specialization = specialization;
        this.region = region;
    }

    public  CriticDto(Long id, String name, String region,Long age,String specialization, LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.age = age;
        this.specialization = specialization;
        this.localDateTime = localDateTime;
    }


}
