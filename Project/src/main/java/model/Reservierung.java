package model;

import model.*;

import javax.persistence.*;
import java.util.Date;
@NamedQuery(
		name="Reservierung.findByEmail",
		query = "SELECT r FROM Reservierung r JOIN FETCH r.benutzer AS b WHERE b.eMail = :email"
		//query = "SELECT r FROM Reservierung r WHERE r.benutzer.eMail = :email"
)
public class Reservierung {

	private Long ID;

	private Date datum;

	private int praemienMeilenBonus = 15;

	private int preis = 150;

	private StatusInfo status;

	private Zug zug;

	private Strecke strecke;

	private Benutzer benutzer;

	private Zahlung zahlung;

}
