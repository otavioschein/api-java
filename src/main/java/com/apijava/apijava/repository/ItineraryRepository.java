package com.apijava.apijava.repository;

import com.apijava.apijava.model.Itinerary;
import com.apijava.apijava.model.Line;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends MongoRepository<Itinerary, String> {
    void insert(JsonNode jsonObject);
}
