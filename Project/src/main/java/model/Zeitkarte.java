package model;


import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class Zeitkarte extends Ticket {

	private Date gueltigAb;

	@Enumerated
	private ZeitkartenTyp typ;

	public  Zeitkarte(){super();}
	public Zeitkarte(Strecke strecke, Zahlung zahlung) {
		super(strecke, zahlung);
	}

	public Zeitkarte(Strecke strecke, Zahlung zahlung, ZeitkartenTyp typ) {
		super(strecke, zahlung);
		this.typ = typ;
	}
}
