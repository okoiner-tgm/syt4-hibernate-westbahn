package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Bahnhof)) return false;
		Bahnhof bahnhof = (Bahnhof) o;
		return absPreisEntfernung == bahnhof.absPreisEntfernung &&
				absKmEntfernung == bahnhof.absKmEntfernung &&
				absZeitEntfernung == bahnhof.absZeitEntfernung &&
				kopfBahnhof == bahnhof.kopfBahnhof &&
				Objects.equals(ID, bahnhof.ID) &&
				Objects.equals(name, bahnhof.name);
	}

	@Override
	public int hashCode() {
		return 0;
	}

	public Bahnhof(){}
	public Bahnhof(@Pattern(regexp = "^[a-zA-Z0-9 -]{2,150}$", message = "Bahnhofsname muss zwischen 2 und 150 Zeichen lang sein und darf abgesehen von \"-\" (Bindestrich)  keine Sonderzeichen enthalten") String name, int absPreisEntfernung, int absKmEntfernung, int absZeitEntfernung, boolean kopfBahnhof) {
		this.name = name;
		this.absPreisEntfernung = absPreisEntfernung;
		this.absKmEntfernung = absKmEntfernung;
		this.absZeitEntfernung = absZeitEntfernung;
		this.kopfBahnhof = kopfBahnhof;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAbsPreisEntfernung() {
		return absPreisEntfernung;
	}

	public void setAbsPreisEntfernung(int absPreisEntfernung) {
		this.absPreisEntfernung = absPreisEntfernung;
	}

	public int getAbsKmEntfernung() {
		return absKmEntfernung;
	}

	public void setAbsKmEntfernung(int absKmEntfernung) {
		this.absKmEntfernung = absKmEntfernung;
	}

	public int getAbsZeitEntfernung() {
		return absZeitEntfernung;
	}

	public void setAbsZeitEntfernung(int absZeitEntfernung) {
		this.absZeitEntfernung = absZeitEntfernung;
	}

	public boolean isKopfBahnhof() {
		return kopfBahnhof;
	}

	public void setKopfBahnhof(boolean kopfBahnhof) {
		this.kopfBahnhof = kopfBahnhof;
	}
}
