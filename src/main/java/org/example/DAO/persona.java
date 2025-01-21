package DAO;
import entities.Persona;
import java.util.List;

public interface persona {
    /**
     *
     * @return todas las personas
     */
    List<Persona> findAll();

    //inserta nueva persona
    void save(Persona persona);

    //delete persona
    void delete(int id);

}