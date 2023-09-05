package com.self.api.core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk")
    private Long pk;
    private String title;
    private String description;
    private String status;
    private String owner;
    @Enumerated(EnumType.STRING)
    private NoteType noteType;
    @Column(name = "modifytime")
    private Date modifyTime;
}
