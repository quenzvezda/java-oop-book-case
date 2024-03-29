package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comic extends CommercialBook {
    private Mangaka author;
    private Boolean volumeSeries;
    private Double tax;

    public Comic(String bookCode, String title, Mangaka author, Publisher publisher, Double price, boolean volumeSeries) {
        super(bookCode, title, publisher, price);
        this.author = author;
        this.volumeSeries = volumeSeries;
        calculatePrice();
        calculateTax();
    }

    @Override
    public Mangaka getAuthor() {
        return this.author;
    }

    @Override
    public void calculatePrice() {
        double multiplier = 1.25;
        if (author.getRating().equalsIgnoreCase("New Commer") && volumeSeries) {
            multiplier = 1.35;
        } else if (author.getRating().equalsIgnoreCase("Good")) {
            multiplier = volumeSeries ? 1.45 : 1.30;
        } else if (author.getRating().equalsIgnoreCase("Best Seller")) {
            multiplier = volumeSeries ? 1.50 : 1.40;
        }
        this.price = publisher.getProductionCost() * multiplier;
    }

    public void calculateTax() {
        this.tax = this.price * 0.05;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "bookCode='" + super.bookCode + '\'' +
                ", title='" + super.title + '\'' +
                ", author=" + author +
                ", publisher=" + super.publisher +
                ", price=" + super.price +
                ", volumeSeries=" + volumeSeries +
                ", tax=" + tax +
                '}';
    }

}
