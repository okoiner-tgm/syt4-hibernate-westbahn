package model;

import model.*;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Reservierung {

    @Id
    @GeneratedValue
	private Long ID;

	private Date datum;

	private int praemienMeilenBonus = 15;

	private int preis = 150;

	private StatusInfo status;

	private Zug zug;

	private Strecke strecke;

	@ManyToOne
	@JoinColumn(name="benutzer_id")
	private Benutzer benutzer;

	private Zahlung zahlung;

}
