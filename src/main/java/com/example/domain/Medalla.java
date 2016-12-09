package com.example.domain;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
public class Medalla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String especialidad;
    private String competicion;
    @ManyToOne
    private Rider rider;

    public Medalla(){}

    public Medalla(Categoria categoria, String especialidad, String competicion) {
        this.categoria = categoria;
        this.especialidad = especialidad;
        this.competicion = competicion;
    }

    public int getId() {return id;}
    public Categoria getCategoria() {return categoria;}
    public String getEspecialidad() {return especialidad;}
    public String getCompeticion() {return competicion;}
    public Rider getRider() {return rider;}

    public void setId(int id) {this.id = id;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public void setCompeticion(String competicion) {this.competicion = competicion;}
    public void setRider(Rider rider) {this.rider = rider;}

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", rider=" + rider +
                '}';
    }
}
