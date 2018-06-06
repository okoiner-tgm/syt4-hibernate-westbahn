package model;

import model.Bahnhof;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;

@Entity
public class Strecke {

	@Id
	@GeneratedValue
	private Long ID;

	@ManyToOne(cascade = CascadeType.ALL)
	private Bahnhof start;

	@ManyToOne(cascade = CascadeType.ALL)
	private Bahnhof bahnhof;

	@ManyToOne(cascade = CascadeType.ALL)
	private Bahnhof ende;


	@AssertTrue(message="Start- und Endbahnhof müssen unterschiedlich sein")
	private boolean isValid() {
		return !start.equals(ende);
	}
	public Strecke(){}
	public Strecke( Bahnhof start, Bahnhof bahnhof, Bahnhof ende) {
		this.start = start;
		this.bahnhof = bahnhof;
		this.ende = ende;
	}

	public Bahnhof getStart() {
		return start;
	}

	public void setStart(Bahnhof start) {
		this.start = start;
	}

	public Bahnhof getBahnhof() {
		return bahnhof;
	}

	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	public Bahnhof getEnde() {
		return ende;
	}

	public void setEnde(Bahnhof ende) {
		this.ende = ende;
	}
}
