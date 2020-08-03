package com.apijava.apijava.model;

import java.util.Date;

public class Taxi {

    private String nome;
    private Double latitude;
    private Double longitude;
    private Date creationTime;

    public Taxi() {}

    public Taxi(String nome, Double latitude, Double longitude, Date creationTime) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.creationTime = creationTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
