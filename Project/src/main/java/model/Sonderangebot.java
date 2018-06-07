package model;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.util.Date;

@Entity
public class Sonderangebot {

    @Id
	@GeneratedValue
	private Long ID;

	private int kontingent = 999;

	@FutureOrPresent(message = "Startzeit kann nicht in der Vergangenheit liegen")
	private Date startZeit;

	private int dauer = 12;

	private float preisNachlass = 0.5f;

	@OneToOne
	private Ticket tickets;
	public Sonderangebot(){}
	public Sonderangebot(int kontingent, @FutureOrPresent(message = "Startzeit kann nicht in der Vergangenheit liegen") Date startZeit, int dauer, float preisNachlass, Ticket tickets) {
		this.kontingent = kontingent;
		this.startZeit = startZeit;
		this.dauer = dauer;
		this.preisNachlass = preisNachlass;
		this.tickets = tickets;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public int getKontingent() {
		return kontingent;
	}

	public void setKontingent(int kontingent) {
		this.kontingent = kontingent;
	}

	public Date getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(Date startZeit) {
		this.startZeit = startZeit;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public float getPreisNachlass() {
		return preisNachlass;
	}

	public void setPreisNachlass(float preisNachlass) {
		this.preisNachlass = preisNachlass;
	}

	public Ticket getTickets() {
		return tickets;
	}

	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}
}
