package br.com.projeto.crud;

public interface InterfaceCrud<T> {

	void save(T obj) throws Exception;

	void clearSession() throws Exception;

	T saveRetorno(T obj) throws Exception;

	void persist(T obj) throws Exception;

	void saveOrUpdate(Object obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(T obj) throws Exception;

	T merge(T obj) throws Exception;

	T find(Class<T> class1, Long id) throws Exception;

}
