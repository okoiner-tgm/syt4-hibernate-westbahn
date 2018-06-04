package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@NamedQuery(
		name="Benutzer.findAllWithMonatskarte",
		query = "SELECT b FROM Benutzer b, Ticket z WHERE b.tickets.typ = model.ZeitkartenTyp.MONATSKARTE"
)
public class Benutzer {

	@Id
	@GeneratedValue
	private Long ID;

	private String vorName;

	private String nachName;

	@Email(message = "Email ungültig")
	private String eMail;

	private String passwort;

	private String smsNummer;

	private Long verbuchtePraemienMeilen;

	@OneToOne
	private Ticket tickets;

	@OneToMany(mappedBy = "benutzer")
	private List<Reservierung> reservierungen;

}
