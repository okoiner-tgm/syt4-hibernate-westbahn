package model;

import javax.persistence.*;

@Entity
@NamedQuery(
		name = "Ticket.findAllByStreckeWithoutReservierung",
		query = "FROM Reservierung r LEFT JOIN FETCH Benutzer b ON b.ID = r.ID "
				+ "RIGHT OUTER JOIN Ticket t ON t.ID = b.id "
				+ "LEFT OUTER JOIN Strecke s ON s.ID = t.id "
				+ "WHERE s.ende = :ende AND s.start = :start HAVING r.ID IS NULL"

)

public abstract class Ticket {

	@Id
	@GeneratedValue
	protected Long ID;

	@OneToOne
	protected Strecke strecke;

	@OneToOne
	protected Zahlung zahlung;

}
