package com.isi.metier.config;

import java.util.Properties;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.isi.metier.entity.Sectors;
import com.isi.metier.entity.Classes;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);

    private HibernateUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                PropertiesReader reader = new PropertiesReader("database.properties");

                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");

                String url = reader.getProperty("db.urlDev");
                String user = reader.getProperty("db.username");
                String pwd = reader.getProperty("db.password");
                LOG.info("dbuser : {}, dbpassword : {}, dbUrl: {}", user, pwd, url);

                settings.put(AvailableSettings.URL, url);
                settings.put(AvailableSettings.USER, user);
                settings.put(AvailableSettings.PASS, pwd);

                settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(AvailableSettings.HBM2DDL_AUTO, "update");

                settings.put(AvailableSettings.SHOW_SQL, "true");
                settings.put(AvailableSettings.FORMAT_SQL, "true");

                settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);

                // AJOUTE TES CLASSES D'ENTITÉS ICI !
                configuration.addAnnotatedClass(Sectors.class);
                configuration.addAnnotatedClass(Classes.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                return sessionFactory;
            } catch (IOException e) {
                LOG.error("Erreur lors de la lecture du fichier de proprietes : {}", e.getMessage());
            } catch (Exception e) {
                LOG.error("Erreur lors de la configuration d'Hibernate : {}", e.getMessage());
            }
        }
        return sessionFactory;
    }
}