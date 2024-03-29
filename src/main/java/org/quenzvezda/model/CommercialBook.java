package org.quenzvezda.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CommercialBook {
    protected String bookCode;
    protected String title;
    protected Publisher publisher;
    protected Double price;

    public abstract Author getAuthor();

    public abstract void calculatePrice();

    @Override
    public String toString() {
        return "Book{" +
                "bookCode='" + bookCode + '\'' +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", price=" + price +
                '}';
    }
}
