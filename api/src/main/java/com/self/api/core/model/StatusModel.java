package com.self.api.core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "status")
@Data
@NoArgsConstructor
public class StatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    private String code;
    private String name;

    @Column(name = "modifytime")
    private Date modifyTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "area_pk")
    private AreaModel area;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "card_pk")
    private CardModel card;



}
