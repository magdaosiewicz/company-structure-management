package com.example.company.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Magda on 23.05.2018.
 */

@Getter
@Entity
@Table(name = "PROJECT")
@EqualsAndHashCode
@ToString()
@NoArgsConstructor
public class Project implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private Long id;
    @Setter
    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;
    @Setter
    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Setter
    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Setter
    @NotNull
    @Column(name = "PROJECTCOL", nullable = false)
    private String projectcol;

    @Setter
    @ManyToMany(fetch = FetchType.EAGER,cascade = {
            CascadeType.ALL,
            CascadeType.MERGE
    })
    @JoinTable(name = "PROJECT_EMPLOYEES",
            joinColumns = @JoinColumn(name = "PROJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID")
    )
    private List<Employee> employeeList;


    @Builder
    public Project(@NotNull String name, @NotNull Date startDate, @NotNull Date endDate, @NotNull String projectcol, List<Employee> employeeList) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectcol = projectcol;
        this.employeeList=employeeList;
    }
}
