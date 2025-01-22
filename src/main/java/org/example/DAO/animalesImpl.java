package org.example.DAO;

import org.example.entities.Animales;
import org.hibernate.Session;
import org.example.Util.HibernateUtil;
import java.util.List;

/**
 * Implementación de la interfaz 'animales'. Esta clase define los métodos
 * para realizar operaciones CRUD sobre la entidad 'Animales' en la base de datos.
 */
public class animalesImpl implements animales {

    /**
     * Recupera todos los animales de la base de datos.
     *
     * @return Una lista de todos los animales.
     */
    @Override
    public List<Animales> findAll() {
        // Abrir la sesión
        Session session = HibernateUtil.getSessionFactory().openSession();

        // HQL para obtener todos los animales
        List<Animales> animales = session.createQuery("from Animales", Animales.class).list();
        session.close();

        return animales;
    }

    /**
     * Recupera animales de la base de datos filtrados por especie.
     *
     * @param especie El nombre o fragmento del nombre de la especie a buscar.
     * @return Una lista de animales que coinciden con la especie proporcionada.
     */
    @Override
    public List<Animales> findByEspecie(String especie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Animales> animales = session.createQuery("from Animales where especie like :especie", Animales.class)
                .setParameter("especie", "%" + especie + "%")
                .list();
        session.close();
        return animales;
    }

    /**
     * Inserta un nuevo animal en la base de datos.
     *
     * @param animales El objeto 'Animales' que se va a guardar en la base de datos.
     * @return El objeto 'Animales' guardado.
     */
    @Override
    public Animales save(Animales animales) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(animales);
        session.getTransaction().commit();
        session.close();
        return animales;
    }

    /**
     * Actualiza la información de un animal en la base de datos.
     * Este método actualmente no tiene implementación.
     *
     * @param animales El objeto 'Animales' con la información actualizada.
     * @return El objeto 'Animales' actualizado.
     */
    @Override
    public Animales update(Animales animales) {
        return null; // Este método no está implementado.
    }

    /**
     * Actualiza el estado de un animal en la base de datos.
     *
     * @param animales El objeto 'Animales' con el estado actualizado.
     * @return El objeto 'Animales' con el estado actualizado.
     */
    @Override
    public Animales updateStatus(Animales animales) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(animales);
        session.getTransaction().commit();
        session.close();
        return animales;
    }

    /**
     * Asigna un usuario a un animal (adopta el animal) en la base de datos.
     *
     * @param id El ID del animal a adoptar.
     * @param id_usuario El ID del usuario que adopta al animal.
     * @return El animal adoptado con el ID del usuario asignado.
     */
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

    /**
     * Recupera todos los animales adoptados (aquellos que tienen un id_usuario asignado).
     *
     * @return Una lista de animales adoptados.
     */
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

    /**
     * Elimina un animal de la base de datos.
     *
     * @param id El ID del animal que se va a eliminar.
     * @return true si la eliminación fue exitosa, false si no se pudo eliminar.
     */
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
