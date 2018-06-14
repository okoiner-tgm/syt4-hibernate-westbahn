import static org.junit.Assert.*;
import model.*;
import org.junit.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationTest {
    private static EntityManagerFactory sessionFactory;
    private static EntityManager em;

    public static <T> boolean isValid(T obj){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        for(ConstraintViolation<T>violation : violations) {
            System.out.println(violation.getMessage());
        }
        return ((Set) violations).size()==0;
    }

    @BeforeClass
    public static void setup(){
        sessionFactory = Persistence.createEntityManagerFactory("westbahnPU");
        em = sessionFactory.createEntityManager();
    }
    @AfterClass
    public static void cleanUp(){
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
    public void validateStrecke1(){
        Bahnhof start = new Bahnhof("nae",1,2,3,false);
        Bahnhof ende = new Bahnhof("na1e",1,2,3,false);
        Strecke s = new Strecke(start ,null,ende);
        assertTrue(isValid(s));
    }
    @Test
    public void validateStrecke2(){
        Bahnhof start = new Bahnhof("nae",1,2,3,false);
        Bahnhof ende = new Bahnhof("na1e",1,2,3,false);
        Strecke s = new Strecke(start ,null,start);
        assertFalse(isValid(s));
    }
    @Test
    public void validateZug1(){
        Bahnhof start = new Bahnhof("nae",1,2,3,false);
        Bahnhof ende = new Bahnhof("na1e",1,2,3,false);
        Zug zug = new Zug(null,1,2,3,start,ende);
        assertTrue(isValid(zug));
    }
    @Test
    public void validateZug2(){
        Bahnhof start = new Bahnhof("nae",1,2,3,false);
        Bahnhof ende = new Bahnhof("na1e",1,2,3,false);
        Zug zug = new Zug(null,1,2,3,start,start);
        assertFalse(isValid(zug));
    }
    @Test
    public void validateBahnhofName1(){
        Bahnhof b = new Bahnhof("bhabdsjfkskjf",1,2,3,true);
       assertTrue(isValid(b));
    }
    @Test
    public void validateBahnhofName2(){
        Bahnhof b = new Bahnhof("b",1,2,3,true);
        assertFalse(isValid(b));
    }
    @Test
    public void validateBahnhofName3(){
        Bahnhof b = new Bahnhof("0012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",1,2,3,true);
        assertFalse(isValid(b));
    }
    @Test
    public void validateBenutzerEmail1(){
        Benutzer b = new Benutzer("vn","nn","ab@cd.at","1234","+123457890",0L,null);
        assertTrue(isValid(b));
    }
    @Test
    public void validateBenutzerEmail2(){
        Benutzer b = new Benutzer("vn","nn","abcd.at","1234","+123457890",0L,null);
        assertFalse(isValid(b));
    }
    @Test
    public void validateBenutzerEmail3(){
        Benutzer b = new Benutzer("vn","nn","ab@ cdat","1234","+123457890",0L,null);
        assertFalse(isValid(b));
    }
    @Test
    public void validateSonderangebotStartzeit1(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1); //minus number would decrement the days
        Sonderangebot s = new Sonderangebot(1,cal.getTime(),1,1.0f,null);
        assertTrue(isValid(s));
    }
    @Test
    public void validateSonderangebotStartzeit2(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1); //minus number would decrement the days
        Sonderangebot s = new Sonderangebot(1,cal.getTime(),1,1.0f,null);
        assertFalse(isValid(s));
    }
}