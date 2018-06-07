import static org.junit.Assert.*;
import org.junit.Test;
import model.*;
import org.junit.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersistenceTests{
    private static EntityManagerFactory sessionFactory;
    private static EntityManager em;
    private Bahnhof bhf;
    private Benutzer benutzer;
    private Einzelticket einzelticket;
    private Reservierung reservierung;
    private Sonderangebot sonderangebot;
    private Strecke strecke;
    private Zeitkarte zeitkarte;
    private Zug zug;
    @BeforeClass
    public static void setup(){
        sessionFactory = Persistence.createEntityManagerFactory("westbahnPU");
        em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery ("DELETE FROM Sonderangebot").executeUpdate();
        em.createQuery ("DELETE FROM Reservierung").executeUpdate();
        em.createQuery ("DELETE FROM Benutzer").executeUpdate();
        em.createQuery ("DELETE FROM Ticket").executeUpdate();
        em.createQuery ("DELETE FROM Einzelticket").executeUpdate();
        em.createQuery ("DELETE FROM Zeitkarte").executeUpdate();
        em.createQuery ("DELETE FROM Strecke").executeUpdate();
        em.createQuery ("DELETE FROM Zug").executeUpdate();
        em.createQuery ("DELETE FROM Bahnhof").executeUpdate();
        em.getTransaction().commit();
    }
    @Before
    public void init(){
        bhf =  new Bahnhof ("bhf2", 100 , 200 , 300 , true );
        Bahnhof bhf2 =  new Bahnhof ("bhf2", 100 , 200 , 300 , true );
        Bahnhof bhf3 =  new Bahnhof ("bhf2", 100 , 200 , 300 , true );
        benutzer = new Benutzer("v","n","a@bsdf.at","1234","+4329219293",0L,null);
        Maestro maestro = new Maestro();
        sonderangebot = new Sonderangebot();
        strecke = new Strecke(bhf,bhf2,bhf3);
        zeitkarte = new Zeitkarte(strecke,maestro,ZeitkartenTyp.MONATSKARTE);
        zug = new Zug(null,3,4,5,bhf,bhf3);
        reservierung = new Reservierung(null,StatusInfo.ONTIME,zug,strecke,benutzer,maestro);
        einzelticket = new Einzelticket(strecke,maestro,TicketOption.FAHRRAD);

        em.persist(bhf);
        em.persist(benutzer);
        em.persist(sonderangebot);
        em.persist(strecke);
        em.persist(zeitkarte);
        em.persist(zug);
        em.persist(reservierung);
        em.persist(einzelticket);


    }
    @After
    public void cleanUp(){
        em.getTransaction().begin();
        em.createQuery ("DELETE FROM Sonderangebot").executeUpdate();
        em.createQuery ("DELETE FROM Reservierung").executeUpdate();
        em.createQuery ("DELETE FROM Benutzer").executeUpdate();
        em.createQuery ("DELETE FROM Ticket").executeUpdate();
        em.createQuery ("DELETE FROM Einzelticket").executeUpdate();
        em.createQuery ("DELETE FROM Zeitkarte").executeUpdate();
        em.createQuery ("DELETE FROM Strecke").executeUpdate();
        em.createQuery ("DELETE FROM Zug").executeUpdate();
        em.createQuery ("DELETE FROM Bahnhof").executeUpdate();
        em.getTransaction().commit();
    }
    @Test
    public void bahnhofTest(){
        assertTrue(em.contains(bhf));
    }
    @Test
    public void benutzerTest(){
        assertTrue(em.contains(benutzer));
    }
    @Test
    public void einzelticketTest(){
        assertTrue(em.contains(einzelticket));
    }
    @Test
    public void reservierungTest(){
        assertTrue(em.contains(reservierung));
    }
    @Test
    public void sonderangebotTest(){
        assertTrue(em.contains(sonderangebot));
    }
    @Test
    public void streckeTest(){
        assertTrue(em.contains(strecke));
    }
    @Test
    public void ticketTest(){
        assertTrue(em.contains(zeitkarte));
    }
    @Test
    public void zugTest(){
        assertTrue(em.contains(zug));
    }
}
