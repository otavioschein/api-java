package com.apijava.apijava.services;

import com.apijava.apijava.model.Itinerary;
import com.apijava.apijava.repository.ItineraryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    public JsonNode findFromApi(Integer id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id));
        itineraryRepository.insert(jsonNode);
//        Itinerary itinerary = mapper.readValue(new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id), Itinerary.class);
        return jsonNode;

    }

    public List<Itinerary> findAll() {return itineraryRepository.findAll();}

    public JsonNode findAllItineraries(Integer id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id));
        System.out.println(jsonNode);
        return jsonNode;
    }

//    public Itinerary findById(Integer id) {
//        Optional<Itinerary> jsonNode = itineraryRepository.findById(id);
//        return jsonNode.orElseThrow();
//    }
}
