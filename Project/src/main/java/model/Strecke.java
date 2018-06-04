package model;

import model.Bahnhof;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.AssertTrue;

@Entity
public class Strecke {

	@Id
	@GeneratedValue
	private Long ID;

	@ManyToOne
	private Bahnhof start;

	@ManyToOne
	private Bahnhof bahnhof;

	@ManyToOne
	private Bahnhof ende;


	@AssertTrue(message="Start- und Endbahnhof müssen unterschiedlich sein")
	private boolean isValid() {
		return !start.equals(ende);
	}

}
