package ro.itschool.curs.service;

import java.util.List;

import ro.itschool.curs.dao.FlightDao;
import ro.itschool.curs.entity.Flight;

public class FlightService {

	private FlightDao flightDao;

	public FlightService() {
		super();
		this.flightDao = new FlightDao();

	}

	public void saveFlight(Flight flight) {
		flightDao.openCurrentSessionwithTransaction();
		flightDao.persist(flight);
		flightDao.closeCurrentSessionwithTransaction();
	}

	public void updateFlight(Flight flight) {
		flightDao.openCurrentSessionwithTransaction();
		flightDao.update(flight);
		flightDao.closeCurrentSessionwithTransaction();
	}

	public Flight findFlightById(int id) {
		flightDao.openCurrentSession();
		Flight flight = flightDao.findById(id);
		flightDao.closeCurrentSession();
		return flight;
	}

	public List<Flight> findFlightByCity(String departurePlace, String destination) throws Exception {
		flightDao.openCurrentSession();
		List<Flight> flights = flightDao.findFlightByCity(departurePlace, destination);
		flightDao.closeCurrentSession();
		return flights;
	}

	public void deleteFlight(Flight flight) {
		flightDao.openCurrentSessionwithTransaction();
		flightDao.delete(flight);
		flightDao.closeCurrentSessionwithTransaction();
	}

	public List<Flight> findAllFlights() {
		flightDao.openCurrentSession();
		List<Flight> list = flightDao.findAll();
		flightDao.closeCurrentSession();
		return list;
	}

	public void deleteAllFlights() {
		flightDao.openCurrentSessionwithTransaction();
		flightDao.deleteAll();
		flightDao.closeCurrentSessionwithTransaction();
	}

}
