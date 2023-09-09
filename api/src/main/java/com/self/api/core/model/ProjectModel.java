package com.self.api.core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    @Column(name = "code",unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "project",cascade = CascadeType.DETACH)
    private List<AreaModel> areas;

    @Column(name = "modifytime")
    private Date modifyTime;

}
