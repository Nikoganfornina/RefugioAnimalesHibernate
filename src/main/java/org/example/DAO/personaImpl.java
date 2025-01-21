package org.example.DAO;

import org.example.Util.HibernateUtil;
import org.example.entities.Persona;
import org.hibernate.Session;

import java.util.List;

public class personaImpl implements persona {
    @Override
    public List<Persona> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Persona> personas = session.createQuery("from Persona", Persona.class).list();
    session.close();
    return personas;
    }

    @Override
    public void save(Persona persona) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(persona);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
