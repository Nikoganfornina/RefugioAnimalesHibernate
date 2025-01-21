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

    private Integer id_usuario;

    public enum EstadoAnimal {
        RECIEN_ABANDONADO,
        TIEMPO_EN_EL_REFUGIO,
        PROXIMAMENTE_EN_ACOGIDA
    }

    @Enumerated(EnumType.STRING)
    private EstadoAnimal estado;


    public Animales() {
    }

    public Animales(Integer id, String nombre, String especie, int edad, String descripcion, EstadoAnimal estado ,Integer id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_usuario = id_usuario;
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

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }


    @Override
    public String toString() {
        return String.format(
                "Animals Details:\n" +
                        "- ID: %d\n" +
                        "- Nombre: %s\n" +
                        "- Especie: %s\n" +
                        "- Edad: %d años\n" +
                        "- Descripción: %s\n" +
                        "- Estado: %s\n" +
                        "- ID del usuario: %s\n",
                id,
                nombre,
                especie,
                edad,
                descripcion,
                estado,
                (id_usuario == null ? "No tiene adopción asignada." : id_usuario)
        );
    }

}
