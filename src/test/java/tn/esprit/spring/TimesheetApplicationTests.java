package tn.esprit.spring;

//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
//import tn.esprit.spring.services.IEmployeService
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests {
	
	@Autowired
	IEmployeService empService ;
	private static final Logger L = LogManager.getLogger(TimesheetApplicationTests.class);

	@Test
	public void contextLoads() {
		
		Contrat e = new Contrat(null, "CDI", 1500);
		 empService.ajouterContrat(e);
		 L.info("ajoute contrat");
	}

}
