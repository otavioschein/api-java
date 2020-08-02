package com.apijava.apijava.resources;

import com.apijava.apijava.model.Line;
import com.apijava.apijava.repository.LineRepository;
import com.apijava.apijava.services.LineService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/linhas")
public class LineResource {

    @Autowired
    private LineService lineService;

    @Autowired
    private LineRepository lineRepository;

    @GetMapping(value = "/todas/api")
    public ResponseEntity findAllApi() throws IOException {
        List<Line> fromApi = lineService.findFromApi();
        return ResponseEntity.ok().body(fromApi);
    }

    @GetMapping(value = "/todas")
    public ResponseEntity  findAllLines() {
        List<Line> list = lineService.findAll();
        return ResponseEntity.ok().body(list);
    }

//    @GetMapping(value = "/itinerarios")
//    public ResponseEntity findItineraries(@RequestParam(value = "id", defaultValue = "") Integer id){
//
//    }

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

    @PostMapping(value = "/registrar")
    public ResponseEntity<Void> register(@RequestBody Line line) {
        Line addLine = lineService.register(line);
        return ResponseEntity.created(URI.create("/lines/" + addLine.getNome())).build();
    }

    @DeleteMapping(value = "/apagar")
    public ResponseEntity delete(@RequestParam(value = "id", defaultValue = "") Integer id) {
        lineService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity update(@RequestParam(value = "id", defaultValue = "") Integer id) {
        Line line = lineService.findById(id);
        lineService.update(line);
        return ResponseEntity.noContent().build();
    }

}
