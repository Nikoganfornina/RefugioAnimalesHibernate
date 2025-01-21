package org.example.DAO;

import org.example.entities.Animales;
import org.hibernate.Session;
import org.example.Util.HibernateUtil;

import java.util.List;

public class animalesImpl implements animales {
    @Override
    public List<Animales> findAll() {
        //Debemos abrir la sesion

        Session session = HibernateUtil.getSessionFactory().openSession();

        //HQL

        List<Animales> animales = session.createQuery("from Animales",Animales.class).list();
        session.close();

        return animales;
    }

    @Override
    public List<Animales> findByEspecie(String especie) {
        return List.of();
    }

    @Override
    public Animales save(Animales animales) {
        return null;
    }

    @Override
    public Animales update(Animales animales) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
