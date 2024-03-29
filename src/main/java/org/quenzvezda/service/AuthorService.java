package org.quenzvezda.service;

import org.quenzvezda.model.Author;
import org.quenzvezda.model.Mangaka;
import org.quenzvezda.model.Novelis;

import java.util.List;

public interface AuthorService {
    public List<Mangaka> findAllMangaka();

    public List<Author> findAllAuthors();

    public List<Novelis> findAllNovelists();

    public List<Author> findAuthorsByAgeRange(int minAge, int maxAge);

    public List<Author> findAuthorsByCountry(String country);
}
