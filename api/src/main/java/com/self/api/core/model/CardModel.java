package com.self.api.core.model;

import com.self.api.core.model.enumtype.NoteType;
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

    @OneToOne(mappedBy = "card")
    private StatusModel status;

    private String owner;

    @Enumerated(EnumType.STRING)
    private NoteType noteType;

    @Column(name = "modifytime")
    private Date modifyTime;

    @ManyToOne
    @JoinColumn(name = "area_pk")
    private AreaModel area;
}
