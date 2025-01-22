package org.example.DAO;

import org.example.entities.Animales;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad 'Animales'.
 * Proporciona métodos para interactuar con la base de datos relacionados con los animales.
 */
public interface animales {

    /**
     * Recupera todos los animales de la base de datos.
     *
     * @return Una lista de todos los animales.
     */
    List<Animales> findAll();

    /**
     * Recupera los animales que coinciden con una especie específica.
     *
     * @param especie La especie de los animales que se buscan.
     * @return Una lista de animales con la especie indicada.
     */
    List<Animales> findByEspecie(String especie);

    /**
     * Inserta un nuevo animal en la base de datos.
     *
     * @param animales El animal que se va a guardar.
     * @return El animal que fue guardado, incluyendo el ID generado.
     */
    Animales save(Animales animales);

    /**
     * Actualiza los detalles de un animal en la base de datos.
     *
     * @param animales El animal con los nuevos detalles.
     * @return El animal actualizado.
     */
    Animales update(Animales animales);

    /**
     * Actualiza el estado de un animal en la base de datos.
     *
     * @param animales El animal cuyo estado se va a actualizar.
     * @return El animal con el estado actualizado.
     */
    Animales updateStatus(Animales animales);

    /**
     * Asocia un animal a un usuario para su adopción.
     *
     * @param id El ID del animal a adoptar.
     * @param id_usuario El ID del usuario que está adoptando al animal.
     * @return El animal con el nuevo estado de adopción.
     */
    Animales adopt(int id, int id_usuario);

    /**
     * Elimina un animal de la base de datos.
     *
     * @param id El ID del animal que se va a eliminar.
     * @return true si el animal fue eliminado correctamente, false en caso contrario.
     */
    boolean delete(int id);
}
