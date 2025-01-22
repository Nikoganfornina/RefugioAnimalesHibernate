package org.example.DAO;

import org.example.entities.Persona;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad 'Persona'.
 * Proporciona métodos para interactuar con la base de datos relacionados con las personas.
 */
public interface persona {

    /**
     * Recupera todas las personas de la base de datos.
     *
     * @return Una lista de todas las personas.
     */
    public List<Persona> findAll();

    /**
     * Inserta una nueva persona en la base de datos.
     *
     * @param persona El objeto Persona que se va a guardar.
     */
    public void save(Persona persona);

    /**
     * Elimina una persona de la base de datos.
     *
     * @param id El ID de la persona que se va a eliminar.
     * @return true si la persona fue eliminada correctamente, false en caso contrario.
     */
    public boolean delete(int id);
}
