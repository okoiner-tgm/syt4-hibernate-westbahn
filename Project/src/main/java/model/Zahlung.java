package model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public interface Zahlung {

	public void zahlungDurchfuehren();

}
