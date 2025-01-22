package org.example.entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Esta clase representa a un animal en el sistema de refugio.
 * La clase mapea la tabla 'animales' en la base de datos.
 */
@Entity
@Table(name = "animales")
public class Animales implements Serializable {

    /**
     * Identificador único del animal. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del animal.
     */
    private String nombre;

    /**
     * Especie del animal (por ejemplo, perro, gato, etc.).
     */
    private String especie;

    /**
     * Edad del animal en años.
     */
    private int edad;

    /**
     * Descripción del animal, como su comportamiento o características.
     */
    private String descripcion;

    /**
     * Identificador del usuario asociado al animal (por ejemplo, el adoptante o responsable).
     */
    private Integer id_usuario;

    /**
     * Enum que define los posibles estados del animal.
     * Los valores posibles son:
     * - RECIEN_ABANDONADO
     * - TIEMPO_EN_EL_REFUGIO
     * - PROXIMAMENTE_EN_ACOGIDA
     */
    public enum EstadoAnimal {
        RECIEN_ABANDONADO,
        TIEMPO_EN_EL_REFUGIO,
        PROXIMAMENTE_EN_ACOGIDA
    }

    /**
     * Estado actual del animal en el refugio.
     */
    @Enumerated(EnumType.STRING)
    private EstadoAnimal estado;

    /**
     * Constructor por defecto para Hibernate.
     */
    public Animales() {
    }

    /**
     * Constructor con parámetros para crear un objeto Animal con sus detalles.
     *
     * @param id El identificador único del animal.
     * @param nombre El nombre del animal.
     * @param especie La especie del animal.
     * @param edad La edad del animal en años.
     * @param descripcion Una breve descripción del animal.
     * @param estado El estado actual del animal (por ejemplo, 'Recién Abandonado').
     * @param id_usuario El identificador del usuario asociado al animal.
     */
    public Animales(Integer id, String nombre, String especie, int edad, String descripcion, EstadoAnimal estado, Integer id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_usuario = id_usuario;
    }

    /**
     * Obtiene el identificador único del animal.
     *
     * @return El identificador del animal.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del animal.
     *
     * @param id El nuevo identificador del animal.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del animal.
     *
     * @return El nombre del animal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del animal.
     *
     * @param nombre El nuevo nombre del animal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la especie del animal.
     *
     * @return La especie del animal.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Establece la especie del animal.
     *
     * @param especie La nueva especie del animal.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Obtiene la edad del animal en años.
     *
     * @return La edad del animal.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del animal en años.
     *
     * @param edad La nueva edad del animal.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la descripción del animal.
     *
     * @return La descripción del animal.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del animal.
     *
     * @param descripcion La nueva descripción del animal.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el estado actual del animal.
     *
     * @return El estado del animal.
     */
    public EstadoAnimal getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del animal.
     *
     * @param estado El nuevo estado del animal.
     */
    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el identificador del usuario asociado al animal.
     *
     * @return El identificador del usuario.
     */
    public Integer getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece el identificador del usuario asociado al animal.
     *
     * @param id_usuario El nuevo identificador del usuario.
     */
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Devuelve una representación en cadena de texto de los detalles del animal.
     *
     * @return Una cadena con los detalles del animal.
     */
    @Override
    public String toString() {
        return String.format(
                "Animal Details:\n" +
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
