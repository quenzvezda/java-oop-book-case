package org.quenzvezda.service;

import lombok.AllArgsConstructor;
import org.quenzvezda.model.CommercialBook;
import org.quenzvezda.model.Publisher;
import org.quenzvezda.repositroy.RepositoryBook;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PublisherService {
    private RepositoryBook repositoryBook;

    public Publisher findPublisherWithHighestProductionCost() {
        return getAllPublishers().stream()
                .max(Comparator.comparing(Publisher::getProductionCost))
                .orElse(null);
    }

    public Publisher findPublisherWithLowestProductionCost() {
        return getAllPublishers().stream()
                .min(Comparator.comparing(Publisher::getProductionCost))
                .orElse(null);
    }

    private List<Publisher> getAllPublishers() {
        return repositoryBook.getAllBooks().stream()
                .map(CommercialBook::getPublisher)
                .distinct()
                .collect(Collectors.toList());
    }
}
