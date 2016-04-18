package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.HibernateUtil;

public abstract class GenericDAO<PK, T> {

	public void insert(T entity) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}
	}

	public void update(T entity) throws HibernateException{

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.merge(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}

	}

	public void delete(T entity) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}
	}

}
