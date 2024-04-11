package ru.edu.penzgtu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


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

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinTable(name = "artist_pictures",
            joinColumns = @JoinColumn(name = "artist_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"))
    @JsonIgnoreProperties("pictures")
    private Artist artist;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinTable(name = "gallery_pictures",
            joinColumns = @JoinColumn(name = "galleries_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    private Gallery gallery;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinTable(name = "critic_pictures",
            joinColumns = @JoinColumn(name = "critic_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"))
    private Critic critic;




}
