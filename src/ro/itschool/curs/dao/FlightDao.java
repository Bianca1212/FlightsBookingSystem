package ro.itschool.curs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Flight;
import ro.itschool.curs.util.HibernateUtils;

@Log
public class FlightDao implements EntityDao<Flight, Integer> {

	private Session session;

	private Transaction transaction;

	public FlightDao() {
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
	public void persist(Flight entity) {
		log.info("Am apelat metoda persist");
		session.save(entity);

	}

	@Override
	public void update(Flight entity) {
		log.info("Am apelat metoda update");
		session.update(entity);
	}

	@Override
	public Flight findById(Integer id) {
		log.info("Am apelat metoda find by id");
		return session.get(Flight.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Flight> findFlightByCity(String departurePlace, String destination) throws Exception {
		log.info("Am apelat metoda find flight by city");
		List<Flight> flights = session.createQuery(
				"from Flight f where f.departurePlace like CONCAT('%',:departurePlace,'%') and f.destination like CONCAT('%',:destination,'%')")
				.setParameter("departurePlace", departurePlace).setParameter("destination", destination).list();
		{
			if (flights.isEmpty())
				throw new Exception("There are no flights available!");
			return flights;
		}
	}

	@Override
	public void delete(Flight entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAll() {
		log.info("Am apelat metoda find all");
		return session.createQuery("from Flight").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda delete all");
		session.createQuery("delete from Flight").executeUpdate();
	}

}
