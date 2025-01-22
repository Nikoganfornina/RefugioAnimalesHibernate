package org.example.DAO;

import org.example.Util.HibernateUtil;
import org.example.entities.Persona;
import org.hibernate.Session;
import java.util.List;

/**
 * Implementación de la interfaz 'persona'. Esta clase define los métodos
 * para realizar operaciones CRUD sobre la entidad 'Persona' en la base de datos.
 */
public class personaImpl implements persona {

    /**
     * Recupera todas las personas de la base de datos.
     *
     * @return Una lista de todas las personas.
     */
    @Override
    public List<Persona> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Persona> personas = session.createQuery("from Persona", Persona.class).list();
        session.close();
        return personas;
    }

    /**
     * Inserta una nueva persona en la base de datos.
     *
     * @param persona El objeto 'Persona' que se va a guardar en la base de datos.
     */
    @Override
    public void save(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(persona);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Elimina una persona de la base de datos.
     *
     * @param id El ID de la persona que se va a eliminar.
     * @return true si la eliminación fue exitosa, false si no se pudo eliminar.
     */
    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(session.get(Persona.class, id));
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
