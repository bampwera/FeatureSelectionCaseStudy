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
 * Home object for domain model class ArticlesKeywords.
 * @see .ArticlesKeywords
 * @author Hibernate Tools
 */
public class ArticlesKeywordsHome {

	private static final Log log = LogFactory
			.getLog(ArticlesKeywordsHome.class);

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

	public void persist(ArticlesKeywords transientInstance) {
		log.debug("persisting ArticlesKeywords instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ArticlesKeywords instance) {
		log.debug("attaching dirty ArticlesKeywords instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ArticlesKeywords instance) {
		log.debug("attaching clean ArticlesKeywords instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ArticlesKeywords persistentInstance) {
		log.debug("deleting ArticlesKeywords instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ArticlesKeywords merge(ArticlesKeywords detachedInstance) {
		log.debug("merging ArticlesKeywords instance");
		try {
			ArticlesKeywords result = (ArticlesKeywords) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ArticlesKeywords findById(ArticlesKeywordsId id) {
		log.debug("getting ArticlesKeywords instance with id: " + id);
		try {
			ArticlesKeywords instance = (ArticlesKeywords) sessionFactory
					.getCurrentSession().get("ArticlesKeywords", id);
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

	public List findByExample(ArticlesKeywords instance) {
		log.debug("finding ArticlesKeywords instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ArticlesKeywords")
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
