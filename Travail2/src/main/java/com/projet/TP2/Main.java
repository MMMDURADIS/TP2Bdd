//Ludovic Hébert et Enrik Bernier
package com.projet.TP2;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projet.Util.HibernateUtil;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.projet.Entites.*;


public class Main {
	private static Boolean faireErreur = true;
	private static Boolean faireRecherche = true;
	private static Boolean erreurProduite = false;
	
	public static void main(String[] args) {
		String message = "Execution";
		System.out.print(message);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// Création et insertion d'Adresses
		    Adresse adresse1 = new Adresse();
		    adresse1.setNumeroRue(123);
		    adresse1.setNomRue("Rue de l'Aviation");
		    adresse1.setVille("Montréal");
		    adresse1.setCodePostal("H1A 2B3");
		    adresse1.setProvince("QC");
		    adresse1.setPays("Canada");
		    session.persist(adresse1);

		    Adresse adresse2 = new Adresse();
		    adresse2.setNumeroRue(456);
		    adresse2.setNomRue("Boulevard des Pilotes");
		    adresse2.setVille("Toronto");
		    adresse2.setCodePostal("M5V 2T6");
		    adresse2.setProvince("ON");
		    adresse2.setPays("Canada");
		    session.persist(adresse2);
		    	

		    // Création et insertion de Types
		    Type type1 = new Type();
		    type1.setNom("Boeing 737");
		    type1.setCapacite(180);
		    type1.setPoids(41413.5);
		    type1.setRayonAction(5765.0);
		    session.persist(type1);

		    Type type2 = new Type();
		    type2.setNom("Airbus A320");
		    type2.setCapacite(150);
		    type2.setPoids(42600.0);
		    type2.setRayonAction(6150.0);
		    session.persist(type2);

		    // Création et insertion de Pilotes
		    Pilote pilote1 = new Pilote();
		    pilote1.setMatricule(1001);
		    pilote1.setNom("Tremblay");
		    pilote1.setPrenom("Jean");
		    pilote1.setAdresse(adresse1);
		    pilote1.setTel("514-555-1234");
		    pilote1.setDateEngagement(new Date());
		    pilote1.setSalaire(85000.50);
		    Set<Type> qualifications1 = new HashSet<>();
		    qualifications1.add(type1);
		    pilote1.setQualifications(qualifications1);
		    session.persist(pilote1);

		    Pilote pilote2 = new Pilote();
		    pilote2.setMatricule(1002);
		    pilote2.setNom("Lefebvre");
		    pilote2.setPrenom("Marie");
		    pilote2.setAdresse(adresse2);
		    pilote2.setTel("416-555-5678");
		    pilote2.setDateEngagement(new Date());
		    pilote2.setSalaire(88000.75);
		    Set<Type> qualifications2 = new HashSet<>();
		    qualifications2.add(type2);
		    pilote2.setQualifications(qualifications2);
		    session.persist(pilote2);

		    // Création et insertion de Techniciens
		    Technicien technicien1 = new Technicien();
		    technicien1.setMatricule(2001);
		    technicien1.setNom("Gagnon");
		    technicien1.setPrenom("Pierre");
		    technicien1.setAdresse(adresse1);
		    technicien1.setTel("514-555-9876");
		    technicien1.setDateEngagement(new Date());
		    technicien1.setSalaire(65000.25);
		    Set<Type> specialisations1 = new HashSet<>();
		    specialisations1.add(type1);
		    technicien1.setSpecialisations(specialisations1);
		    session.persist(technicien1);

		    Technicien technicien2 = new Technicien();
		    technicien2.setMatricule(2002);
		    technicien2.setNom("Bouchard");
		    technicien2.setPrenom("Sophie");
		    technicien2.setAdresse(adresse2);
		    technicien2.setTel("416-555-4321");
		    technicien2.setDateEngagement(new Date());
		    technicien2.setSalaire(67000.50);
		    Set<Type> specialisations2 = new HashSet<>();
		    specialisations2.add(type2);
		    technicien2.setSpecialisations(specialisations2);
		    session.persist(technicien2);

		    // Création et insertion d'Avions
		    Avion avion1 = new Avion();
		    avion1.setMatricule(3001);
		    avion1.setType(type1);
		    session.persist(avion1);

		    Avion avion2 = new Avion();
		    avion2.setMatricule(3002);
		    avion2.setType(type2);
		    session.persist(avion2);

		    // Création et insertion de Réparations
		    Reparation reparation1 = new Reparation();
		    reparation1.setAvion(avion1);
		    reparation1.setTechnicien(technicien1);
		    reparation1.setCoutTotal(5000.75);
		    reparation1.setDate(new Date());
		    session.persist(reparation1);

		    Reparation reparation2 = new Reparation();
		    reparation2.setAvion(avion2);
		    reparation2.setTechnicien(technicien2);
		    reparation2.setCoutTotal(6500.50);
		    reparation2.setDate(new Date());
		    session.persist(reparation2);

		    // Création et insertion de Tests
		    Test test1 = new Test();
		    test1.setNumero(4001);
		    test1.setNom("Test Pression");
		    test1.setSeuil(0.95);
		    session.persist(test1);

		    Test test2 = new Test();
		    test2.setNumero(4002);
		    test2.setNom("Test Étanchéité");
		    test2.setSeuil(0.95);
		    session.persist(test2);

		    // Création et insertion d'AvionTest
		    AvionTest avionTest1 = new AvionTest();
		    avionTest1.setAvion(avion1);
		    avionTest1.setTest(test1);
		    avionTest1.setDate(new Date());
		    session.persist(avionTest1);

		    AvionTest avionTest2 = new AvionTest();
		    avionTest2.setAvion(avion2);
		    avionTest2.setTest(test2);
		    avionTest2.setDate(new Date());
		    session.persist(avionTest2);
		    transaction.commit();
		    
		    
		    transaction = session.beginTransaction();
		    
		    if (faireErreur)
		    	PersistMauvaisCodePostal(session);
		    transaction.commit();
		    transaction = null;
		    
		    if (faireRecherche)
		    	FaireRechercheCodePostal();
			
		} catch (Exception e) {
			if (transaction != null) {
			transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (!erreurProduite) {
				message = "Fin de l'exécution, appuyer sur n'importe quel touche pour finir et réinitialiser";
		        System.out.println(message);
		        Scanner scanner = new Scanner(System.in);
		        try {
		        	scanner.nextLine();
		        } catch(java.util.NoSuchElementException e) {
		        } finally {
		        	scanner.close();
		        }
			}
			
			System.out.println("Fermeture du programme");
	        session.close();
			HibernateUtil.shutdown();
			NettoyerIndex();
		}

	}
	
	public static void PersistMauvaisCodePostal(Session session) {
		
		System.out.print("Violation de la condition optionnelle :\n");
		
		Adresse adresse3 = new Adresse();
		adresse3.setNumeroRue(456);
	    adresse3.setNomRue("Boulevard des Pilotes");
	    adresse3.setVille("Toronto");
	    adresse3.setCodePostal("M5M  5M5");
	    adresse3.setProvince("ON");
	    adresse3.setPays("Canada");
	    
	    
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Adresse>> violations = validator.validate(adresse3);

        // Affiche les violations
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Adresse> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
            violations.clear();
        } else {
            System.out.println("Aucune violation détectée");
            session.persist(adresse3);
        }
	    
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Appuyer pour continuer et tester la violation de la condition normale");
	    adresse3.setCodePostal("MMM 5M5");
	    scanner.nextLine();
	    
        violations = validator.validate(adresse3);

        // Affiche les violations
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Adresse> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
            violations.clear();
        } else {
            System.out.println("Aucune violation détectée");
            session.persist(adresse3);
        }
        
        System.out.println("Appuyer pour tester un code valide");
	    adresse3.setCodePostal("M5q8v7");
	    scanner.nextLine();
	    
        violations = validator.validate(adresse3);

        // Affiche les violations
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Adresse> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
            violations.clear();
        } else {
            System.out.println("Aucune violation détectée");
            session.persist(adresse3);
        }
	    
	    System.out.println("Appuyer pour terminer ce test");
	    scanner.nextLine();
	    scanner.close();
	    
	    return;
	}
	
	static void FaireRechercheCodePostal() {
		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		SearchSession searchSession = Search.session(entityManager);
		MassIndexer indexer = searchSession.massIndexer( Adresse.class ).threadsToLoadObjects(1);
		try {
			indexer.startAndWait();
			System.out.println("Recherche avec critere");
			List<Adresse> result = searchSession.search(Adresse.class)
			    .where(f -> f.match()
			        .field("codePostal")
			        .matching("H1A"))
			    .fetchHits(20);
			result.forEach(adresse -> System.out.println("Adresse "+adresse.getId()+": " + adresse.getCodePostal()));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Appuyer pour finir la recherche");
	    if (scanner.hasNextLine()) {
	        scanner.nextLine();
	    } else
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    scanner.close();
	}
	
	public static void NettoyerIndex() {
		String folderPath = "Adresse";

        File folder = new File(folderPath);
        
        System.out.println("Recherche dossier");
        if (!folder.isDirectory())
        	return;
        System.out.println("Dossier Trouvé");
        File[] files = folder.listFiles();
        if (files == null) 
        	return;
        System.out.println("Fichiers trouvés");
        for (File file : files) {
            if (file.isFile())
            	file.delete();
        }
        System.out.println("Fichiers supprimés");
	}
	
}

