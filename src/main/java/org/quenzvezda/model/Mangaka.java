package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Mangaka extends Author{
    private String rating;

    public Mangaka(String rating) {
        this.rating = rating;
    }

    public Mangaka(String firstName, String lastName, String country, int age, String rating) {
        super(firstName, lastName, country, age);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Mangaka{" +
                "rating='" + rating + '\'' +
                "} " + super.toString();
    }
}
