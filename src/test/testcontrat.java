package tn.esprit.spring
//package tn.esprit.spring

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IEmployeService

@RunWith(SpringRunner.class)
@SpringBootTest
public class testcontrat {
 
	
	@Autowired
	IEmployeService empService ;
 
	//IUserService userservice;
	@Test
	public void testuser() {
	//	UserConsomi u = new UserConsomi("user", "user", "mourouj", "123456", "145263987", "abdallah.gmail.com", "aa", "22", 3652, 25, 2);
		//userservice.saveUser(u);
		//Contrat c = new Contrat(dateDebut, typeContrat, salaire) 
		Contrat e = new Contrat("Null", "CDI", 1500);
		 empService.ajouterContrat(e);
	}

}
