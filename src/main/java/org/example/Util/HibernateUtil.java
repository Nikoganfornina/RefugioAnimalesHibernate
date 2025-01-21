package org.example.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    /**
     * Crea una SessionFactory basada en un archivo de configuración.
     * Si no se especifica archivo, usa el predeterminado `hibernate.cfg.xml`.
     *
     * @param configFile Nombre del archivo de configuración (puede ser null)
     * @return SessionFactory configurada
     */
    public static SessionFactory getSessionFactory(String configFile) {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            if (configFile != null && !configFile.isEmpty()) {
                configuration.configure(configFile);
            } else {
                configuration.configure(); // Usa el archivo predeterminado
            }
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    /**
     * Obtiene la SessionFactory ya creada (sin especificar archivo de configuración).
     * Esto usa el archivo predeterminado `hibernate.cfg.xml`.
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return getSessionFactory(null);
    }

    /**
     * Cierra la SessionFactory.
     */
    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
