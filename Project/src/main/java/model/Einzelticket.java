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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Einzelticket)) return false;
		Einzelticket that = (Einzelticket) o;
		return ticketOption == that.ticketOption;
	}
}
