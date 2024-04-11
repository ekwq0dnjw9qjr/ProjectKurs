package ru.edu.penzgtu.entity;

import jakarta.persistence.*;
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

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "dateAndTime")
    private LocalDateTime localDateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gallery_pictures",
            joinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "galleries_id", referencedColumnName = "id"))
    private List<Picture> pictures;




}
