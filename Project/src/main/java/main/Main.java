package main;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

// import model.*;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	private static EntityManagerFactory sessionFactory;
	@PersistenceContext
	private static EntityManager entitymanager;
	static SimpleDateFormat dateForm = new SimpleDateFormat("dd.MM.yyyy");
	static SimpleDateFormat timeForm = new SimpleDateFormat("dd.MM.yyyy mm:hh");

	private Main() {
		super();
	}

	public static void main(String[] args) {
		log.setLevel(Level.ALL);
		try {
			log.info("Starting \"Mapping Perstistent Classes and Associations\" (task1)");
			sessionFactory = Persistence.createEntityManagerFactory("westbahnPU");
			
			fillDB(entitymanager);
			task01();
			log.info("Starting \"Working with JPA-QL and the Hibernate Criteria API\" (task2)");
			task02a();
			task02b();
			task02c();
			System.out.println("Hello");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fillDB(EntityManager em) throws ParseException {
		em = sessionFactory.createEntityManager();

	}
	
	public static void task01() throws ParseException, InterruptedException {
	}
	public static void task02a() throws ParseException {
	    /*
		EntityManager em = sessionFactory.createEntityManager();
		Query q = em.createNamedQuery("Reservierung.findByEmail");
		q.setParameter("email","astrasser@student.tgm.ac.at");
		List<Reservierung> rs = q.getResultList();
		System.out.println(rs.size());
	     */
	}

	public static void task02b() throws ParseException {
	    /*
		EntityManager em = sessionFactory.createEntityManager();
		Query q = em.createNamedQuery("Benutzer.findAllWithMonatskarte");
		List<Benutzer> rs = q.getResultList();
		System.out.println(rs.size());
		for(Benutzer b: rs){
			System.out.println(b.geteMail());
		}
	     */
	}

	public static void task02c() throws ParseException {
	    /*
		EntityManager em = sessionFactory.createEntityManager();
		Query q = em.createNamedQuery("Ticket.findAllByStreckeWithoutReservierung");
		q.setParameter("start","bhf1");
		q.setParameter("ende","bhf3");
		List<Ticket> rs = q.getResultList();
		System.out.println(rs.size());
	     */
	}

}
