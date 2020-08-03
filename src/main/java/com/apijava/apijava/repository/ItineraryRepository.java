package com.apijava.apijava.repository;

import com.apijava.apijava.model.Itinerary;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItineraryRepository extends MongoRepository<Itinerary, String> {
    void insert(JsonNode jsonObject);
}
