package org.example.config;

import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.Member;
import org.example.entities.Reservation;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Member.class);
            configuration.addAnnotatedClass(Reservation.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return this.sessionFactory;
    }
}
