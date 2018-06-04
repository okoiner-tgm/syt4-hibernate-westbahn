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

}
