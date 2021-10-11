package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
	@Autowired
	IEmployeService es;

	private static final Logger l = LogManager.getLogger(EmployeeTest.class);

	@Test
	public void verifTaille() {
		List<Employe> employes = es.getAllEmployes();
		System.out.println("****************************");
		assertTrue(employes.size() > 0);
		l.info("Taille: " + employes.size());
	}

	@Test
	public void verifEmail() {
		Employe employe = es.getAllEmployes().get(0);
		System.out.println("****************************");
		assertEquals("kallel", employe.getNom());
		assertTrue(employe.getEmail().contains(".tn"));
		l.info("Employe: " + employe.getEmail());
	}
	
	@Test
    public void test() {
    	Integer i=es.getNombreEmployeJPQL();
    	
    	Employe emp = new Employe();
        emp.setNom("BenMansour");
        emp.setPrenom("Ahmed");
        emp.setEmail("hmedM@esprit.tn");
        es.ajouterEmploye(emp);
        l.info("Nbr: " + es.getNombreEmployeJPQL());
        assertEquals(i + 1,es.getNombreEmployeJPQL());}
}
