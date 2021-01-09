package io.biblioteca.db;

import io.biblioteca.Livro;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class DBSessaoFactory {

    private static SessionFactory sessionFactory;

    static SessionFactory build() {

        if(sessionFactory == null) {

            Map<String, String> propertiesMap = new HashMap<>();
            propertiesMap.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            propertiesMap.put(Environment.URL, "jdbc:mysql://localhost:3306/biblioteca?allowPublicKeyRetrieval=true&useSSL=false");
            propertiesMap.put(Environment.USER, "root");
            propertiesMap.put(Environment.PASS, "root");
            propertiesMap.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            propertiesMap.put(Environment.SHOW_SQL, "true");
            propertiesMap.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            propertiesMap.put(Environment.HBM2DDL_AUTO, "create-drop");

            Properties properties = new Properties();

            for(Map.Entry<String, String> property : propertiesMap.entrySet()) {
                properties.put(property.getKey(), property.getValue());
            }

            Configuration hibernateConfiguration = new Configuration();
            hibernateConfiguration.setProperties(properties);
            hibernateConfiguration.addAnnotatedClass(Livro.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(propertiesMap)
                    .build();

            sessionFactory = hibernateConfiguration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
