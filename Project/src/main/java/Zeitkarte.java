import org.hibernate.annotations.Entity;

import java.util.Date;

@Entity
public class Zeitkarte extends Ticket {

	private Date gueltigAb;

	private ZeitkartenTyp typ;

}
