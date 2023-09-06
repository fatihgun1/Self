package com.self.api.core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "area")
@Data
@NoArgsConstructor
public class AreaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    private String code;
    private String name;
    private String owner;

    @OneToMany(mappedBy = "area",cascade = CascadeType.DETACH)
    private List<StatusModel> status;

    @OneToMany(mappedBy = "area",cascade = CascadeType.DETACH)
    private List<CardModel> cards;

    @Column(name = "modifytime")
    private Date modifyTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "project_pk")
    private ProjectModel project;
}
