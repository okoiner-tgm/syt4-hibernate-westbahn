package model;

import javax.persistence.*;

@Entity
@NamedQuery(
		name = "Ticket.findAllByStreckeWithoutReservierung",
		query = "FROM Ticket t WHERE t.strecke.start.name = :start AND t.strecke.ende.name = :ende AND t.strecke IN (SELECT S2 FROM Strecke s2 WHERE s2 NOT IN"+
				"(SELECT s FROM Strecke s, Reservierung r WHERE s = r.strecke))"


)
public abstract class Ticket {

	@Id
	@GeneratedValue
	protected Long ID;

	@OneToOne(cascade = CascadeType.PERSIST)
	protected Strecke strecke;

	@Embedded
	protected Zahlung zahlung;

	public Ticket(Strecke strecke, Zahlung zahlung) {
		this.strecke = strecke;
		this.zahlung = zahlung;
	}

	public Ticket() {
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Strecke getStrecke() {
		return strecke;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	public Zahlung getZahlung() {
		return zahlung;
	}

	public void setZahlung(Zahlung zahlung) {
		this.zahlung = zahlung;
	}
}
