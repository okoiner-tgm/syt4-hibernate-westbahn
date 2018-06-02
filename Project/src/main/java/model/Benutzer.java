package model;

import javax.persistence.*;

@Entity
public class Benutzer {

	@Id
	@GeneratedValue
	private Long ID;

	private String vorName;

	private String nachName;

	private String eMail;

	private String passwort;

	private String smsNummer;

	private Long verbuchtePraemienMeilen;

	@OneToOne
	private Ticket tickets;

	@OneToMany(mappedBy = "benutzer")
	private Reservierung[] reservierungen;

}
