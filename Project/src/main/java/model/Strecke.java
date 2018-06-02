package model;

import model.Bahnhof;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Strecke {

	@Id
	@GeneratedValue
	private Long ID;

	@ManyToOne
	private Bahnhof start;

	private Bahnhof bahnhof;

	@ManyToOne
	private Bahnhof ende;

}
