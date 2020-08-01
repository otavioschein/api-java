package com.apijava.apijava.services;

import com.apijava.apijava.model.Line;
import com.apijava.apijava.repository.LineRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

    public List<Line> findFromApi() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Line> list = mapper.readValue(new URL("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o"), new TypeReference<List<Line>>(){});

        return list;
    }

    public

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public List<String> findAllNames() {
        List<String> listNames = new ArrayList<>();
        List<Line> list = findAll();
        for (Line line: list) {
            listNames.add(line.getNome());
        }
        return listNames;
    }

    public List<Line> findByName(String name) {
        name = Url.decodeParam(name);
        return lineRepository.findByName(name);
    }
}
