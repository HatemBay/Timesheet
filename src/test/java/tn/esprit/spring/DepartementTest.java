package tn.esprit.spring;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	@Autowired
	EntrepriseServiceImpl es;

	private static final Logger l = LogManager.getLogger(DepartementTest.class);

	@Test
	public void verifySize() {
		List<String> departements = es.getAllDepartementsNamesByEntreprise(1);
		System.out.println("--------");
		assertTrue(departements.size() > 0);
		l.info("Size: " + departements.size());
	}

	@Test
	public void verifyName() {
		List<String> departement = es.getAllDepartementsNamesByEntreprise(1);
		System.out.println("--------");
		assertTrue(departement.contains("esprit"));
		l.info("Departement: " + departement);
	}
}
