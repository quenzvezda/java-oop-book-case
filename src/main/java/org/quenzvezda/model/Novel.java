package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Novel extends CommercialBook {
    private Novelis author;
    private String genre;

    public Novel(String bookCode, String title, Novelis author, Publisher publisher, Double price, String genre) {
        super(bookCode, title, publisher, price);
        this.author = author;
        this.genre = genre;
        calculatePrice();
    }

    @Override
    public void calculatePrice() {
        switch (author.getRating().toLowerCase()) {
            case "new commer":
                this.price = publisher.getProductionCost() * 1.25;
                break;
            case "good":
                this.price = publisher.getProductionCost() * 1.35;
                break;
            case "best seller":
                this.price = publisher.getProductionCost() * 1.50;
                break;
            default:
                // TODO Create Exception to throw error
                break;
        }
    }

    @Override
    public Novelis getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "bookCode='" + super.bookCode + '\'' +
                ", title='" + super.title + '\'' +
                ", author=" + author +
                ", publisher=" + super.publisher +
                ", price=" + super.price +
                ", genre='" + genre + '\'' +
                '}';
    }

}
