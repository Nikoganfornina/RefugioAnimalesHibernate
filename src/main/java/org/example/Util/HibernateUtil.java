package org.example.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para la configuración y obtención de la sesión de Hibernate.
 * Esta clase proporciona un método estático para obtener una instancia de {@link SessionFactory} configurada.
 */
public class HibernateUtil {

    /**
     * Obtiene la instancia de {@link SessionFactory} configurada para interactuar con la base de datos.
     * La configuración se carga a través del archivo de configuración de Hibernate (hibernate.cfg.xml).
     *
     * @return Una instancia de {@link SessionFactory} que se puede usar para obtener sesiones de Hibernate.
     */
    public static SessionFactory getSessionFactory() {
        // Crear configuración de Hibernate
        Configuration configuration = new Configuration();

        // Cargar configuración desde el archivo hibernate.cfg.xml
        configuration.configure();

        // Devolver la fábrica de sesiones configurada
        return configuration.buildSessionFactory();
    }
}
