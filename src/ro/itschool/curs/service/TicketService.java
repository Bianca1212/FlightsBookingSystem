package ro.itschool.curs.service;

import java.util.List;

import ro.itschool.curs.dao.TicketDao;
import ro.itschool.curs.entity.Ticket;

public class TicketService {

	private TicketDao ticketDao;

	public TicketService() {
		super();
		this.ticketDao = new TicketDao();
	}

	public void saveTicket(Ticket ticket) {
		ticketDao.openCurrentSessionwithTransaction();
		ticketDao.persist(ticket);
		ticketDao.closeCurrentSessionwithTransaction();
	}

	public void updateTicket(Ticket ticket) {
		ticketDao.openCurrentSessionwithTransaction();
		ticketDao.update(ticket);
		ticketDao.closeCurrentSessionwithTransaction();
	}

	public Ticket findTicketById(int id) {
		ticketDao.openCurrentSession();
		Ticket ticket = ticketDao.findById(id);
		ticketDao.closeCurrentSession();
		return ticket;

	}

	public void deleteTicket(Ticket ticket) {
		ticketDao.openCurrentSessionwithTransaction();
		ticketDao.delete(ticket);
		ticketDao.closeCurrentSessionwithTransaction();
	}

	public List<Ticket> findAllTickets() {
		ticketDao.openCurrentSession();
		List<Ticket> list = ticketDao.findAll();
		ticketDao.closeCurrentSession();
		return list;
	}

	public void deleteAllTickets() {
		ticketDao.openCurrentSessionwithTransaction();
		ticketDao.deleteAll();
		ticketDao.closeCurrentSessionwithTransaction();
	}

}
