package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Publisher {
    private String publisherName;
    private String country;
    private double productionCost;
}
