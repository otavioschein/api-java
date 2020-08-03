package com.apijava.apijava.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return id.equals(line.id) &&
                codigo.equals(line.codigo) &&
                nome.equals(line.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nome);
    }
}
