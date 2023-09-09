package com.self.api.facades.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDTO {

    private String code;
    private String title;
    private String description;
    private StatusDTO status;
    private String owner;
    private String noteType;

}
