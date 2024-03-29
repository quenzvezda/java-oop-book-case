package org.quenzvezda.service.impl;

import lombok.AllArgsConstructor;
import org.quenzvezda.model.Comic;
import org.quenzvezda.model.CommercialBook;
import org.quenzvezda.repositroy.RepositoryBook;
import org.quenzvezda.service.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private RepositoryBook repositoryBook;

    @Override
    public CommercialBook findCheapestBook() {
        return repositoryBook.getAllBooks().stream()
                .min(Comparator.comparing(CommercialBook::getPrice))
                .orElse(null);
    }

    @Override
    public CommercialBook findMostExpensiveBook() {
        return repositoryBook.getAllBooks().stream()
                .max(Comparator.comparing(CommercialBook::getPrice))
                .orElse(null);
    }

    @Override
    public List<CommercialBook> findBooksByPriceRange(double minPrice, double maxPrice) {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book.getPrice() >= minPrice && book.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    @Override
    public List<Comic> findComicsByMangakaRating(String rating) {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book instanceof Comic)
                .map(book -> (Comic) book)
                .filter(comic -> comic.getAuthor().getRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommercialBook> findBooksByPublisherCountry(String country) {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book.getPublisher().getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommercialBook> findBooksByAuthorCountry(String country) {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book.getAuthor().getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    @Override
    public Comic findMostExpensiveComic() {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book instanceof Comic)
                .map(book -> (Comic) book)
                .max(Comparator.comparing(Comic::getPrice))
                .orElse(null);
    }

}
