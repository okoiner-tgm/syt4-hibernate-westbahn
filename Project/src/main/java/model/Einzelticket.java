package model;


import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Einzelticket extends Ticket {

	@Enumerated
	private TicketOption ticketOption;

	public Einzelticket(){super();}
	public Einzelticket(Strecke strecke, Zahlung zahlung, TicketOption ticketOption) {
	    super(strecke,zahlung);
	    this.ticketOption = ticketOption;
	}
}
