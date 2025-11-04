package vt05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = factory.openSession();
        session.close();
        factory.close();
    }
}
