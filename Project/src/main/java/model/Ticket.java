package model;

import javax.persistence.*;

@Entity
@NamedQuery(
		name = "Ticket.findAllByStreckeWithoutReservierung",
		query = "FROM Ticket t WHERE t.strecke IN (SELECT S2 FROM Strecke s2 WHERE s2 NOT IN"+
				"(SELECT s FROM Strecke s, Reservierung r WHERE s = r.strecke))"


)
public abstract class Ticket {

	@Id
	@GeneratedValue
	protected Long ID;

	@OneToOne
	protected Strecke strecke;

	@Embedded
	protected Zahlung zahlung;

}
