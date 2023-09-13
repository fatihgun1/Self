package com.self.api.core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "status")
@Data
@NoArgsConstructor
public class StatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    @Column(unique = true)
    private String code;
    private String name;

    @Column(name = "modifytime")
    private Date modifyTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "area_pk")
    private AreaModel area;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "status")
    private List<CardModel> card;

}
