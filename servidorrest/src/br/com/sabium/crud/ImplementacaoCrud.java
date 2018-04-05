package br.com.sabium.crud;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.sabium.hibernate.HibernateUtil;

@SuppressWarnings("unchecked")
public class ImplementacaoCrud<T> implements InterfaceCrud<T> {

	private static SessionFactory s = HibernateUtil.getSessionFactory();

	@Override
	public void save(T obj) throws Exception {
		s.getCurrentSession().beginTransaction();
		s.getCurrentSession().save(obj);
		executeFlushSession();
		s.getCurrentSession().beginTransaction().commit();
	}

	public T find(Class<T> class1, Long id) {

		s.getCurrentSession().beginTransaction();
		T t = (T) s
				.getCurrentSession()
				.createQuery(
						" from " + class1.getSimpleName() + " where id = " + id)
				.uniqueResult();
		s.getCurrentSession().beginTransaction().commit();
		return t;
	}

	public void persist(T entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		s.getCurrentSession().persist(entidade);
		executeFlushSession();
		s.getCurrentSession().beginTransaction().commit();
	}

	public void saveOrUpdate(Object entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		s.getCurrentSession().saveOrUpdate(entidade);
		executeFlushSession();
		s.getCurrentSession().beginTransaction().commit();
	}

	public void update(T entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		s.getCurrentSession().update(entidade);
		executeFlushSession();
		s.getCurrentSession().beginTransaction().commit();
	}

	public void delete(T entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		s.getCurrentSession().delete(entidade);
		executeFlushSession();
		s.getCurrentSession().beginTransaction().commit();
	}

	public T merge(T entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		entidade = (T) s.getCurrentSession().merge(entidade);
		executeFlushSession();
		s.getCurrentSession().beginTransaction().commit();
		return entidade;
	}

	public List<T> finList(Class<T> entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		StringBuilder query = new StringBuilder();
		query.append("select distinct(o) from ")
				.append(entidade.getSimpleName()).append(" o ");
		List<T> lista = s.getCurrentSession().createQuery(query.toString())
				.list();
		s.getCurrentSession().beginTransaction().commit();
		return lista;
	}

	public List<T> finListQuery(Class<T> entidade, String sql) throws Exception {
		s.getCurrentSession().beginTransaction();
		List<T> lista = s.getCurrentSession().createQuery(sql.toString())
				.list();
		s.getCurrentSession().beginTransaction().commit();
		return lista;
	}

	public void evict(Object entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		s.getCurrentSession().evict(entidade);
		s.getCurrentSession().beginTransaction().commit();
	}

	public T saveRetorno(T entidade) throws Exception {
		s.getCurrentSession().beginTransaction();
		Object t = this.merge(entidade);
		executeFlushSession();
		s.getCurrentSession().clear();
		s.getCurrentSession().beginTransaction().commit();
		return (T) t;
	}

	private void executeFlushSession() throws Exception {
		s.getCurrentSession().flush();
	}

	@Override
	public void clearSession() {
		s.getCurrentSession().clear();
	}

	@Override
	public void save(List<T> list) {
		if (!list.isEmpty()) {
			try {
				s.getCurrentSession().beginTransaction();

				for (T t : list) {
					s.getCurrentSession().save(t);

				}
				executeFlushSession();
				s.getCurrentSession().beginTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				s.getCurrentSession().beginTransaction().rollback();
			}
		}
	}

}
