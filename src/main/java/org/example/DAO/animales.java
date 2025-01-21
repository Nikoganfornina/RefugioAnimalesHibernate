package org.example.DAO;

import org.example.entities.Animales;

import java.util.List;

public interface animales {

    /**
     *
     * @Return
     */

    List<Animales> findAll();

    //@return devuelve un animal por su especie
    List<Animales> findByEspecie(String especie);

    //Inserta un nuevo animal a la base de datos
    Animales save(Animales animales);

    //Actualizar estado
    Animales update(Animales animales);

    Animales updateStatus(Animales animales);

    Animales adopt(int id, int id_usuario);

    /**
     *
     * @param id
     */
    boolean delete(int id);
}
