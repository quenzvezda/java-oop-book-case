package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
