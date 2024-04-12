package ru.edu.penzgtu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(name = "name",nullable = false,length = 55)
    @NotBlank
    private String name;

    @Column(name = "specialization",nullable = false,length = 55)
    @NotBlank
    private String specialization;

    @Column(name = "region",nullable = false,length = 55)
    private String region;

    @Column(name = "age")
    @Positive(message = "Возрост должен быть положительным числом")
    private Long age;

    @Column(name = "date_and_time")
    @NotNull(message = "Дата и время не должны быть пустыми")
    private LocalDateTime localDateTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(name = "critic_pictures",
            joinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "critic_id",referencedColumnName = "id"))
    private List<Picture> pictures;}
