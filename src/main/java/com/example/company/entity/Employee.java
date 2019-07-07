package com.example.company.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Magda on 23.05.2018.
 */

@Getter
@Entity
@Table(name = "EMPLOYEES")
@EqualsAndHashCode
@ToString()
@NoArgsConstructor
@Setter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Setter
    @ManyToOne(cascade = CascadeType.REFRESH )
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @Setter
    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Setter
    @NotNull
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Setter
    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String emai;

    @ManyToMany(fetch = FetchType.EAGER ,cascade = {
            CascadeType.ALL,
            CascadeType.MERGE
    })
    @JoinTable(name = "PROJECT_EMPLOYEES",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    private List<Project> projectList;


    @Builder
    public Employee(@NotNull Department department, @NotNull String name, @NotNull String surname, @NotNull String email) {
        this.department=department;
        this.name = name;
        this.surname=surname;
        this.emai=email;
    }




}
