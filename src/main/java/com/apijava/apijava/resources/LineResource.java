package com.apijava.apijava.resources;

import com.apijava.apijava.model.Line;
import com.apijava.apijava.repository.LineRepository;
import com.apijava.apijava.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/linhas")
public class LineResource {

    @Autowired
    private LineService lineService;

    @Autowired
    private LineRepository lineRepository;

    @GetMapping(value = "/todas")
    public ResponseEntity findAll() throws IOException, InterruptedException {
        List<Line> fromApi = lineService.findFromApi();
        lineRepository.insert(fromApi);
        return ResponseEntity.ok().body(fromApi);
    }

    @GetMapping(value = "/itinerarios")
    public ResponseEntity findItineraries(@RequestParam(value = "id", defaultValue = "") Integer id){

    }

    @GetMapping(value = "/nome")
    public ResponseEntity<List<Line>> findByName(@RequestParam(value = "text", defaultValue = "") String name) {
        List<Line> listName = lineService.findByName(name);
        return ResponseEntity.ok().body(listName);
    }

    @GetMapping(value = "/nomes")
    public ResponseEntity<List<String>> findAllNames() {
        List<String> listNames = lineService.findAllNames();
        return ResponseEntity.ok().body(listNames);
    }
}
