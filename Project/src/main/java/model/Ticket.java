package model;

import org.hibernate.annotations.Entity;

@Entity
public abstract class Ticket {

	protected Long ID;

	protected Strecke strecke;

	protected Zahlung zahlung;

}
