package com.apijava.apijava.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "itinerario")
public class Itinerary{

    private String idLinha;
    private String nome;
    private String codigo;
    private List<Location> itinerario;
    private JsonNode itin;

    public Itinerary(){}

    public Itinerary(String idLinha, String nome, String codigo, List<Location> itinerario, JsonNode itin) {
        this.idLinha = idLinha;
        this.nome = nome;
        this.codigo = codigo;
        this.itinerario = itinerario;
        this.itin = itin;
    }

    public String getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(String idLinha) {
        this.idLinha = idLinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Location> getItinerario() {
        return itinerario;
    }

    public void setItinerario(List<Location> itinerario) {
        this.itinerario = itinerario;
    }

    public JsonNode getItin() {
        return itin;
    }

    public void setItin(JsonNode itin) {
        this.itin = itin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerary itinerary = (Itinerary) o;
        return idLinha.equals(itinerary.idLinha) &&
                nome.equals(itinerary.nome) &&
                codigo.equals(itinerary.codigo) &&
                itinerario.equals(itinerary.itinerario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLinha, nome, codigo, itinerario);
    }
}

@JsonRootName(value = "location")
class Location {
    private String lat;
    private String lng;

    public Location(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
