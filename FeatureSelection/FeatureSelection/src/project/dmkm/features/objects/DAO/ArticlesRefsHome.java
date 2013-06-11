package project.dmkm.features.objects.DAO;
// default package
// Generated Mar 29, 2013 10:59:55 PM by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ArticlesRefs.
 * @see .ArticlesRefs
 * @author Hibernate Tools
 */
public class ArticlesRefsHome {

	private static final Log log = LogFactory.getLog(ArticlesRefsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ArticlesRefs transientInstance) {
		log.debug("persisting ArticlesRefs instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ArticlesRefs instance) {
		log.debug("attaching dirty ArticlesRefs instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ArticlesRefs instance) {
		log.debug("attaching clean ArticlesRefs instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ArticlesRefs persistentInstance) {
		log.debug("deleting ArticlesRefs instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ArticlesRefs merge(ArticlesRefs detachedInstance) {
		log.debug("merging ArticlesRefs instance");
		try {
			ArticlesRefs result = (ArticlesRefs) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ArticlesRefs findById(ArticlesRefsId id) {
		log.debug("getting ArticlesRefs instance with id: " + id);
		try {
			ArticlesRefs instance = (ArticlesRefs) sessionFactory
					.getCurrentSession().get("ArticlesRefs", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ArticlesRefs instance) {
		log.debug("finding ArticlesRefs instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ArticlesRefs")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
