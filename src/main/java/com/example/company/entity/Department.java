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
@Table(name = "DEPARTMENTS")
@EqualsAndHashCode
@ToString()
@NoArgsConstructor
@Setter
public class Department implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH )
    @JoinColumn(name = "LOCALIZATION_ID")
    private Localization localization;

    @Setter
    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;


    @Builder
    public Department(@NotNull String name, @NotNull Localization localization) {
        this.name = name;
        this.localization=localization;
    }


}
