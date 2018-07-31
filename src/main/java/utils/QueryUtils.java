package utils;

import javax.persistence.EntityManager;

public abstract class QueryUtils {

	protected static EntityManager em;

	protected static void persist(Object... objects) {
		executeInTransaction("persist", objects);
	}

	protected static void refresh(Object... objects) {
		// TODO
	}

	private static void executeInTransaction(String opt, Object... objects) {

		em.getTransaction().begin();
		switch (opt) {

		case "refresh":
			for (Object obj : objects) {
				em.refresh(obj);
			}
			break;

		case "persist":
			for (Object obj : objects) {
				em.persist(obj);
			}
			break;
		}
		em.getTransaction().commit();

	}

	public static void setEm(EntityManager em) {
		QueryUtils.em = em;
	}

}
