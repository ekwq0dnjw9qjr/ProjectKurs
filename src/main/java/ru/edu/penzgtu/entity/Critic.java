package ru.edu.penzgtu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "critics")
public class Critic {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "specialization")
    @NotBlank
    private String specialization;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "critics_pictures",
            joinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "critics_id",referencedColumnName = "id"))
    private List<Picture> pictures;
}
