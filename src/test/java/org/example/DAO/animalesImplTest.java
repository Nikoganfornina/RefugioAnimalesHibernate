package org.example.DAO;

import org.example.Util.HibernateUtil;
import org.example.entities.Animales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.example.entities.Animales.EstadoAnimal.*;

public class animalesImplTest {

    @Test
    void createtableTest() {
        // Crear la fábrica de sesiones
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            // Limpia la tabla antes de comenzar el test
            session.beginTransaction();
            session.createQuery("DELETE FROM Animales").executeUpdate();
            session.getTransaction().commit();

            // Insertar un animal en la base de datos
            Animales animal1 = new Animales(null, "Mortox", "Suricato Cabron", 20,
                    "Es más feo que pegarle a un padre", RECIEN_ABANDONADO, null);

            session.beginTransaction();
            session.persist(animal1);
            session.getTransaction().commit();

            System.out.println("Animal creado exitosamente en la base de datos.");

            // Verificar que el animal fue creado
            session.beginTransaction();
            Animales fetchedAnimal = session.get(Animales.class, animal1.getId());
            if (fetchedAnimal != null) {
                System.out.println("El animal existe en la base de datos: " + fetchedAnimal);
            } else {
                throw new RuntimeException("El animal no se encontró en la base de datos.");
            }
            session.getTransaction().commit();

            // Eliminar el animal recién creado
            session.beginTransaction();
            session.createQuery("DELETE FROM Animales WHERE id = :id")
                    .setParameter("id", animal1.getId())
                    .executeUpdate();
            session.getTransaction().commit();

            System.out.println("Animal eliminado exitosamente de la base de datos.");

            // Limpieza total final para garantizar un entorno limpio
            session.beginTransaction();
            session.createQuery("DELETE FROM Animales").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Tabla limpia tras la ejecución del test.");
        } catch (Exception e) {
            // Manejo de errores
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            session.close();
            sessionFactory.close();
        }
    }
}
