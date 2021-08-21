package br.com.tarefas.util;

import java.util.Objects;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory entityManagerFactory;

	private HibernateUtil() {}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (Objects.isNull(entityManagerFactory)) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("tarefas");
			} catch (Exception ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
			}
		}
		return entityManagerFactory;
	}

}
