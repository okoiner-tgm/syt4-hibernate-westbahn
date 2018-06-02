package model;


import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Einzelticket extends Ticket {

	@Enumerated
	private TicketOption ticketOption;

}
