package org.example.DAO;

import org.example.entities.Persona;

import java.util.List;

public interface persona {
    /**
     *
     * @return todas las personas
     */
    public List<Persona> findAll();

    //insertar nueva persona
    public void save(Persona persona);

    /**
     *
     * @param id
     */
    public boolean delete(int id);

}
