package model;


import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class Zeitkarte extends Ticket {

	private Date gueltigAb;

	@Enumerated
	private ZeitkartenTyp typ;

}
