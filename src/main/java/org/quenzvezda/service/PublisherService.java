package org.quenzvezda.service;

import org.quenzvezda.model.Publisher;

public interface PublisherService {
    public Publisher findPublisherWithHighestProductionCost();

    public Publisher findPublisherWithLowestProductionCost();
}
