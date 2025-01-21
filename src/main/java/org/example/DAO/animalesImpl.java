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

        List<Animales> animales = session.createQuery("from Animales", Animales.class).list();
        session.close();

        return animales;
    }

    @Override
    public List<Animales> findByEspecie(String especie) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Animales> animales = session.createQuery("from Animales where especie = :especie", Animales.class).setParameter("especie", especie).list();
        session.close();
        return animales;

    }

    @Override
    public Animales save(Animales animales) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(animales);
        session.getTransaction().commit();
        session.close();
        return animales;

    }

    @Override
    public Animales updateStatus(Animales animales) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(animales);
        session.getTransaction().commit();
        session.close();
        return animales;

    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
