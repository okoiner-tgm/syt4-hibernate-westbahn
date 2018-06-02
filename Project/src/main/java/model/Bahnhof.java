package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Bahnhof")
public class Bahnhof {

	@Id
	@GeneratedValue
	private Long ID;


	@Pattern(regexp = "^[a-zA-Z0-9 -]{2,150}$", message = "Bahnhofsname muss zwischen 2 und 150 Zeichen lang sein und darf abgesehen von \"-\" (Bindestrich)  keine Sonderzeichen enthalten")
	private String name;

	private int absPreisEntfernung;

	private int absKmEntfernung;

	private int absZeitEntfernung;

	private boolean kopfBahnhof;

}
