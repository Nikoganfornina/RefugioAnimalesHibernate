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
        List<Animales> animales = session.createQuery("from Animales where especie like :especie", Animales.class)
                .setParameter("especie", "%" + especie + "%")
                .list();
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
    public Animales update(Animales animales) {
        return null;
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
    public Animales adopt(int id, int id_usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animales animales = session.get(Animales.class, id);
        animales.setId_usuario(id_usuario);
        session.update(animales);
        session.getTransaction().commit();
        session.close();
        return animales;
    }
    public List<Animales> adoptados() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // HQL para obtener animales con id_usuario asociado
        String hql = "FROM Animales WHERE id_usuario IS NOT NULL";
        List<Animales> animalesAdoptados = session.createQuery(hql, Animales.class).getResultList();

        session.getTransaction().commit();
        session.close();

        // Imprimir la lista de animales adoptados
        if (animalesAdoptados.isEmpty()) {
            System.out.println("No hay animales adoptados.");
        } else {
            System.out.println("Animales adoptados:");
            animalesAdoptados.forEach(System.out::println);
        }

        return animalesAdoptados;
    }

    @Override
    public boolean delete(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(session.get(Animales.class, id));
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
