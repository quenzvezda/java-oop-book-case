package org.quenzvezda.service.impl;

import lombok.AllArgsConstructor;
import org.quenzvezda.model.*;
import org.quenzvezda.repositroy.RepositoryBook;
import org.quenzvezda.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private RepositoryBook repositoryBook;

    @Override
    public List<Mangaka> findAllMangaka() {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book instanceof Comic)
                .map(book -> (Comic) book)
                .map(Comic::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> findAllAuthors() {
        return repositoryBook.getAllBooks().stream()
                .map(CommercialBook::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Novelis> findAllNovelists() {
        return repositoryBook.getAllBooks().stream()
                .filter(book -> book instanceof Novel)
                .map(book -> (Novel) book)
                .map(Novel::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> findAuthorsByAgeRange(int minAge, int maxAge) {
        return findAllAuthors().stream()
                .filter(author -> author.getAge() >= minAge && author.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> findAuthorsByCountry(String country) {
        return findAllAuthors().stream()
                .filter(author -> author.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

}
