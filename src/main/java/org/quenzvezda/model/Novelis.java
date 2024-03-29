package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Novelis extends Author {
    private boolean serial;
    private String rating;

    public Novelis(String firstName, String lastName, String country, int age, boolean serial, String rating) {
        super(firstName, lastName, country, age);
        this.serial = serial;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Novelis{" +
                "serial=" + serial +
                ", rating='" + rating + '\'' +
                "} " + super.toString();
    }
}
