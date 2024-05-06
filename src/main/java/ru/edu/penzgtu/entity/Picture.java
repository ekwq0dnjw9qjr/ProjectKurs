package ru.edu.penzgtu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.edu.penzgtu.dto.PictureDto;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false,length = 77)
    private String name;

    @Column(name = "genre",nullable = false,length = 77)
    private String genre;

    @Column(name = "technique",nullable = false,length = 77)
    private String technique;

    @Column(name = "price")
    @Positive(message = "Цена должна быть положительным числом")
    private Long price;

    @Column(name = "date_and_time")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties("pictures")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @ManyToOne
    @JoinColumn(name = "critic_id")
    private Critic critic;
}
