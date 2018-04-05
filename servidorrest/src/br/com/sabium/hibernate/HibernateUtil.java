package br.com.sabium.hibernate;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				sessionFactory = (new Configuration()).configure()
						.buildSessionFactory();
			}
			return sessionFactory;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(
					"Erro ao criar conexăo SessionFactory");
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			buildSessionFactory();

		return sessionFactory;
	}

	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public static void startSession() {
		if (sessionFactory == null)
			buildSessionFactory();
	}

	public static Session getSession() {
		if (sessionFactory == null)
			buildSessionFactory();
		return sessionFactory.openSession();
	}

	@SuppressWarnings("deprecation")
	public static Connection getConnection() {
		return sessionFactory.getCurrentSession().connection();
	}

}
