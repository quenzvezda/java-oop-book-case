package org.quenzvezda.service;

import org.quenzvezda.model.Comic;
import org.quenzvezda.model.CommercialBook;

import java.util.List;

public interface BookService {
    public CommercialBook findCheapestBook();

    public CommercialBook findMostExpensiveBook();

    public List<CommercialBook> findBooksByPriceRange(double minPrice, double maxPrice);

    public List<Comic> findComicsByMangakaRating(String rating);

    public List<CommercialBook> findBooksByPublisherCountry(String country);

    public List<CommercialBook> findBooksByAuthorCountry(String country);

    public Comic findMostExpensiveComic();
}
