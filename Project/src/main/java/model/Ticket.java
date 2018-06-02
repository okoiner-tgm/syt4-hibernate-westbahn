package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public abstract class Ticket {

	@Id
	@GeneratedValue
	protected Long ID;

	@OneToOne
	protected Strecke strecke;

	@OneToOne
	protected Zahlung zahlung;

}
