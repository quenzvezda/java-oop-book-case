package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EBook extends CommercialBook {
    private Author author;
    @Override
    public void calculatePrice() {
        price = publisher.getProductionCost() * 1.2;
    }

    public EBook(String bookCode, String title, Author author, Publisher publisher, Double price) {
        super(bookCode, title, publisher, price);
        this.author = author;
        calculatePrice();
    }

    @Override
    public Author getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "bookCode='" + super.bookCode + '\'' +
                ", title='" + super.title + '\'' +
                ", author=" + author +
                ", publisher=" + super.publisher +
                ", price=" + super.price +
                '}';
    }

}
