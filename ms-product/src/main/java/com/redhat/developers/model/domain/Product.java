package com.redhat.developers.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;

}
