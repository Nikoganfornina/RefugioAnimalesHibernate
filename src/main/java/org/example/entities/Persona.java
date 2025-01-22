package org.example.entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Esta clase representa a una persona en el sistema.
 * La clase mapea la tabla 'personas' en la base de datos.
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    /**
     * Identificador único de la persona. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre de la persona.
     */
    private String nombre;

    /**
     * Ciudad donde reside la persona.
     */
    private String ciudad;

    /**
     * Edad de la persona.
     */
    private int edad;

    /**
     * Constructor por defecto para Hibernate.
     */
    public Persona() {
    }

    /**
     * Constructor con parámetros para crear una persona con sus detalles.
     *
     * @param id El identificador único de la persona.
     * @param nombre El nombre de la persona.
     * @param ciudad La ciudad donde reside la persona.
     * @param edad La edad de la persona.
     */
    public Persona(Integer id, String nombre, String ciudad, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    /**
     * Obtiene el identificador único de la persona.
     *
     * @return El identificador de la persona.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único de la persona.
     *
     * @param id El nuevo identificador de la persona.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ciudad de la persona.
     *
     * @return La ciudad de la persona.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde reside la persona.
     *
     * @param ciudad La nueva ciudad de la persona.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve una representación en cadena de texto de los detalles de la persona.
     *
     * @return Una cadena con los detalles de la persona.
     */
    @Override
    public String toString() {
        return String.format(
                "User Details:\n" +
                        "- ID: %d\n" +
                        "- Nombre: %s\n" +
                        "- Ciudad: %s\n" +
                        "- Edad: %d años\n",
                id, nombre, ciudad, edad
        );
    }
}
