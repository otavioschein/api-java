package com.apijava.apijava.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "linha")
public class Line {

    private Integer  id;
    private String codigo;
    private String nome;

    public Line() {}

    public Line(Integer id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}


}
