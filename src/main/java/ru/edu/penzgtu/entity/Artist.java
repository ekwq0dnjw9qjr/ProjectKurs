package ru.edu.penzgtu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "country")
    @NotBlank
    private String country;

    @Column(name = "dateAndTime")
    private LocalDateTime localDateTime;

    @Column(name = "style")
    private String style;

    @Column(name = "quote")
    private String quote;




    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "artist_pictures",
            joinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "artist_id",referencedColumnName = "id"))
    @JsonIgnoreProperties({"artist","id","critics","gallery","dateAndTime"})

    private List<Picture> pictures = new ArrayList<>();

}