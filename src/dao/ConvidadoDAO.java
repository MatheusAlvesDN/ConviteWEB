package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidades.Convidado;
import hibernate.HibernateUtil;

public class ConvidadoDAO extends GenericDAO<Integer, Convidado>{

	private static ConvidadoDAO instance;

	public static ConvidadoDAO getInstance() {	

		instance = new ConvidadoDAO();	

		return instance;

	}

	public Convidado getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Convidado convidado = null;

		try {

			session.beginTransaction();
			convidado = (Convidado) session.get(Convidado.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return convidado;
	}

	@SuppressWarnings("unchecked")
	public List <Convidado> getAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List <Convidado> convidados = null;
		String convidado = "Convidado";

		try {

			String hql = "from Pessoa where DTYPE = :convidado";

			Query query = session.createQuery(hql);
			query.setParameter("convidado", convidado);

			convidados = (List<Convidado>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return convidados;
	}

	public Convidado getByNome(String nome){

		Session session = HibernateUtil.getSessionFactory().openSession();

		Convidado convidado = null;

		try {

			String hql = "from Pessoa where nome = :nome";

			Query query = session.createQuery(hql);
			query.setParameter("nome", nome);

			convidado = (Convidado) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return convidado;
	}
}
