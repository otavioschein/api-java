package com.apijava.apijava.resources;

import com.apijava.apijava.repository.ItineraryRepository;
import com.apijava.apijava.services.ItineraryService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/itinerarios")
public class ItineraryResource {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private ItineraryService itineraryService;

    @GetMapping(value = "/pontos")
    public ResponseEntity<Object> findFromApi(@RequestParam(value = "id", defaultValue = "")  Integer id) throws IOException {
        JsonNode jsonNode = itineraryService.findFromApi(id);
        itineraryRepository.insert(jsonNode);
        return ResponseEntity.ok().body(jsonNode);
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<Object> findAllItineraries(@RequestParam(value = "id", defaultValue = "") Integer id) throws IOException {
        JsonNode jsonNode = itineraryService.findAllItineraries(id);
        return ResponseEntity.ok().body(jsonNode);
    }
}
