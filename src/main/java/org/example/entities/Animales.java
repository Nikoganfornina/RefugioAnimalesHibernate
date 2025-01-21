package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "animales")
public class Animales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String especie;

    private int edad;

    private String descripcion;

    public enum EstadoAnimal {
        RECIEN_ABANDONADO,
        TIEMPO_EN_EL_REFUGIO,
        PROXIMAMENTE_EN_ACOGIDA
    }

    private EstadoAnimal estado;


    public Animales() {
    }

    public Animales(Integer id, String nombre, String especie, int edad, String descripcion, EstadoAnimal estado) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return String.format(
                "Animal Details:\n" +
                        "- ID: %d\n" +
                        "- Nombre: %s\n" +
                        "- Especie: %s\n" +
                        "- Edad: %d años\n" +
                        "- Descripción: %s",
                id, nombre, especie, edad, descripcion
        );
    }


}
