package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class CustomerDao implements EntityDao<Customer, Integer> {

	private Session session;

	private Transaction transaction;

	public CustomerDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}

	@Override
	public void persist(Customer entity) {
		log.info("Am apelat metoda persist");
		session.save(entity);

	}

	@Override
	public void update(Customer entity) {
		log.info("Am apelat metoda update");
		session.update(entity);
	}

	@Override
	public Customer findById(Integer id) {
		log.info("Am apelat metoda find by id");
		return session.get(Customer.class, id);
	}

	@Override
	public void delete(Customer entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		log.info("Am apelat metoda find All");
		return session.createQuery("from Customer").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda delete all");
		session.createQuery("delete from Customer").executeUpdate();
	}
}
