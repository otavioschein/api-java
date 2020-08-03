package com.apijava.apijava.services;

import com.apijava.apijava.model.Line;
import com.apijava.apijava.repository.LineRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

    public List<Line> findFromApi() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Line> list = mapper.readValue(new URL("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o"), new TypeReference<List<Line>>(){});
        lineRepository.insert(list);
        return list;
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public List<String> findAllNames() {
        List<String> listNames = new ArrayList<>();
        List<Line> list = findAll();
        for (Line line : list) {
            listNames.add(line.getNome());
        }
        return listNames;
    }

    public List<Line> findByName(String name) {
        name = Url.decodeParam(name);
        return lineRepository.findByName(name);
    }

    public Line findById(Integer id) {
        Optional<Line> obj = lineRepository.findById(id);
        return obj.orElseThrow();
    }

    public Line register(Line line) {
        Optional<Line> exists = lineRepository.findById(line.getId());
        if (exists.isEmpty()) {
            lineRepository.insert(line);
        } else if (!exists.isEmpty() && line.equals(exists)) {
            update(line);
        }
        return line;
    }

    public void delete(Integer id) {
        Optional<Line> deleteLine = lineRepository.findById(id);
        lineRepository.deleteById(id);
    }

    public Line update(Line newLine) {
        Line existsLine = findById(newLine.getId());
        existsLine.setCodigo(newLine.getCodigo());
        existsLine.setNome(newLine.getNome());
        return lineRepository.save(existsLine);
    }


}
