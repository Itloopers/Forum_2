package listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import utils.QueryUtils;

/**
 * Application Lifecycle Listener implementation class EntityManagerReguest
 *
 */
@WebListener
public class EntityManagerReguest implements ServletRequestListener {
	EntityManager em;

	public void requestDestroyed(ServletRequestEvent sre) {
		if (em != null & em.isOpen())
			em.close();
	}

	public void requestInitialized(ServletRequestEvent sre) {
		em = ConListener.getEntityManagerFactory().createEntityManager();
		QueryUtils.setEm(em);
	}

}
