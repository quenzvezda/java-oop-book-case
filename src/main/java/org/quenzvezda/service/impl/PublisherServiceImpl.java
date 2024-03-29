package org.quenzvezda.service.impl;

import lombok.AllArgsConstructor;
import org.quenzvezda.model.CommercialBook;
import org.quenzvezda.model.Publisher;
import org.quenzvezda.repositroy.RepositoryBook;
import org.quenzvezda.service.PublisherService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private RepositoryBook repositoryBook;

    @Override
    public Publisher findPublisherWithHighestProductionCost() {
        return getAllPublishers().stream()
                .max(Comparator.comparing(Publisher::getProductionCost))
                .orElse(null);
    }

    @Override
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
