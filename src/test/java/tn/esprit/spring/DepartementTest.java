package tn.esprit.spring;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	
	@Autowired
	DepartementServiceImpl esx;
	
	@Autowired
	DepartementRepository depRepository; 

	private static final Logger l = LogManager.getLogger(DepartementTest.class);
	
	
	@Test
	public void verifTaille() {
		List<Departement> dep = esx.getAlldep();
		assertTrue(!dep.isEmpty());
		String s = "Taille: " + dep.size();
		l.info(s);
	}

	@Test
	public void verifName() {
		Departement dep = esx.getAlldep().get(0);
		assertEquals("test", dep.getName());
		l.info("dep name : " + dep.getName());
	}


	
	@Test
	public void supprimerDep() {
		  Departement dep = esx.ajouterDepartement(new Departement("dep"));
	

		  depRepository.delete(dep);
		
		
		assertEquals(null,depRepository.findById(dep.getId()).orElse(null));
	
		
	}
	
	@Test
	public void CreateDep() {
	
		Departement dep = esx.ajouterDepartement(new Departement("dep"));
		 assertThat(dep.getId()).isGreaterThan(0);
		 depRepository.delete(dep);
		
	
	}
	
	@Test
	public void modifierDep() {
		Departement dep = esx.ajouterDepartement(new Departement("dep"));
		dep.setName("depmodidifer");
		Departement mod =	depRepository.save(dep);
		l.info("dep_description: " + mod.getName());
		assertEquals("depmodidifer",mod.getName());
		depRepository.delete(dep);
		
	}

}
