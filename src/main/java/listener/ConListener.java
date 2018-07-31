package listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConListener implements ServletContextListener {
	private static EntityManagerFactory emf;

	public void contextDestroyed(ServletContextEvent sce) {
		if (emf != null && emf.isOpen())
			emf.close();
	}

	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory("manager2");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

}
