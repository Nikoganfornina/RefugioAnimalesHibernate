package org.example.entities;


import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String ciudad;
    private String edad;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String ciudad, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format(
                "Users Details:\n" +
                        "- ID: %d\n" +
                        "- Nombre: %s\n" +
                        "- Ciudad: %s\n" +
                        "- Edad: %d años\n",
                id, nombre, ciudad, edad
        );
    }
}
