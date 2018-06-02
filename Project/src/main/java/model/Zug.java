package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertTrue;
import java.util.Date;

@Entity
public class Zug {

	@Id
	@GeneratedValue
	private Long ID;

	private Date startZeit;

	private int sitzPlaetze = 500;

	private int fahrradStellplaetze = 50;

	private int rollStuhlPlaetze = 10;

	@OneToOne
	private Bahnhof start;

	@OneToOne
	private Bahnhof ende;


	@AssertTrue(message="Start- und Endbahnhof müssen unterschiedlich sein")
	private boolean isValid() {
		return !start.equals(ende);
	}

}
