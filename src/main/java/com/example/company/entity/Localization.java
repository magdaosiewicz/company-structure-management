package com.example.company.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Magda on 20.05.2018.
 */
@Getter
@Entity
@Table(name = "LOCALIZATIONS")
@EqualsAndHashCode
@ToString()
@NoArgsConstructor
public class Localization implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCALIZATION_ID")
    private Long id;

    @Setter
    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Setter
    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Builder
    public Localization(@NotNull String name, @NotNull String address) {
        this.name = name;
        this.address = address;
    }
}
