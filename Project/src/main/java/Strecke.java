import org.hibernate.annotations.Entity;

@Entity
public class Strecke {

	private Long ID;

	private Bahnhof start;

	private Bahnhof bahnhof;

	private Bahnhof ende;

}
