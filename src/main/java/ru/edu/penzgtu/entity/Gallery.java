package ru.edu.penzgtu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table( name = "Galleries")
public class Gallery {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false,length = 66)
    @NotBlank
    private String name;

    @Column(name = "country",nullable = false,length = 66)
    @NotBlank
    private String country;

    @Column(name = "city",nullable = false,length = 66)
    private String city;

    @Column(name = "street",nullable = false,length = 66)
    private String street;

    @Column(name = "date_and_time")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "gallery",fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Picture> pictures;
}
