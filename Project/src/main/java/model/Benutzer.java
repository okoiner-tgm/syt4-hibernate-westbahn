package model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NamedQuery(
		name="Benutzer.findAllWithMonatskarte",
		query = "SELECT b FROM Benutzer b WHERE TYPE(b.tickets) = 'Zeitkarte'"
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
	private Reservierung[] reservierungen;

}
