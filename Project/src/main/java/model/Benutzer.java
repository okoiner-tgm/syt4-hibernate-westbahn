package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@NamedQuery(
		name="Benutzer.findAllWithMonatskarte",
		query = "SELECT b FROM Benutzer b WHERE b.tickets.typ = model.ZeitkartenTyp.MONATSKARTE"
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

	@OneToOne(cascade = PERSIST)
	private Ticket tickets;

	@OneToMany(mappedBy = "benutzer",cascade = PERSIST)
	private List<Reservierung> reservierungen;
	public Benutzer(){}
	public Benutzer(String vorName, String nachName, @Email(message = "Email ungültig") String eMail, String passwort, String smsNummer, Long verbuchtePraemienMeilen, Ticket tickets) {
		this.vorName = vorName;
		this.nachName = nachName;
		this.eMail = eMail;
		this.passwort = passwort;
		this.smsNummer = smsNummer;
		this.verbuchtePraemienMeilen = verbuchtePraemienMeilen;
		this.tickets = tickets;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getSmsNummer() {
		return smsNummer;
	}

	public void setSmsNummer(String smsNummer) {
		this.smsNummer = smsNummer;
	}

	public Long getVerbuchtePraemienMeilen() {
		return verbuchtePraemienMeilen;
	}

	public void setVerbuchtePraemienMeilen(Long verbuchtePraemienMeilen) {
		this.verbuchtePraemienMeilen = verbuchtePraemienMeilen;
	}

	public Ticket getTickets() {
		return tickets;
	}

	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}

	public List<Reservierung> getReservierungen() {
		return reservierungen;
	}

	public void setReservierungen(List<Reservierung> reservierungen) {
		this.reservierungen = reservierungen;
	}
}
