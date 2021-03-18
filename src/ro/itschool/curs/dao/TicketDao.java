package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Ticket;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class TicketDao implements EntityDao<Ticket, Integer> {
	
	private Session session;

	private Transaction transaction;

	public TicketDao() {
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
	public void persist(Ticket entity) {
		log.info("Am apelat metoda persist");
		session.save(entity);
		
	}

	@Override
	public void update(Ticket entity) {
		log.info("Am apelat metoda update");
		session.update(entity);
	}

	@Override
	public Ticket findById(Integer id) {
		log.info("Am apelat metoda find by id");
		return session.get(Ticket.class, id);
	}

	@Override
	public void delete(Ticket entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAll() {
		log.info("Am apelat metoda find all");
		return session.createQuery("from Flight").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda delete all");
		session.createQuery("delete from Flight").executeUpdate();
		
	}


}
