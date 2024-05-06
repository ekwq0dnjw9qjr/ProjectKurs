package ru.edu.penzgtu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false,length = 44)
    private String name;

    @Column(name = "country",nullable = false,length = 44)
    private String country;

    @Column(name = "date_and_time")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;

    @Column(name = "style",nullable = false,length = 155)
    private String style;

    @Column(name = "quote",nullable = false,length = 4444)
    private String quote;


    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"artist","id","critics","gallery","dateAndTime"})
    private List<Picture> pictures = new ArrayList<>();}