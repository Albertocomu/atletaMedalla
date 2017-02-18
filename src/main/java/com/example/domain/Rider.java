package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    /*private LocalDate birthday;
    @OneToMany (mappedBy = "rider")
    @JsonIgnore
    private Set<Medalla> medallas;*/

    public Rider() {
    }

    public Rider(String nombre, String apellidos, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        //this.birthday = birthday;
        //this.medallas = new HashSet<>();
    }

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getNacionalidad() {return nacionalidad;}
    //public LocalDate getBirthday() {return birthday;}
    //public Set<Medalla> getMedallas() {return medallas;}

    public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
    //public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    //public void setMedallas(Set<Medalla> medallas) {this.medallas = medallas;}

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                //", birthday=" + birthday +
                '}';
    }
}
