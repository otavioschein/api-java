package com.apijava.apijava.resources;

import com.apijava.apijava.model.Taxi;
import com.apijava.apijava.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/taxi")
public class TaxiResource {

    @Autowired
    private TaxiService taxiService;

    @PostMapping(value = "/registrar")
    public ResponseEntity register(@RequestBody Taxi taxi) {
        taxiService.register(taxi);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/listar")
    public ResponseEntity listContent() {
        String foundTaxi = taxiService.listContent();
        return ResponseEntity.ok().body(foundTaxi);
    }

}
