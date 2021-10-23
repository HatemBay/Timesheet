package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class DepartementServiceImpl  implements IDepartementService{
	
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;

	@Autowired
	MissionRepository missionRepository;
	
	@Autowired
	DepartementRepository depRepository;

	@Override
	public Departement ajouterDepartement(Departement dep) {
		depRepository.save(dep);
	 		return dep;
	}

	@Override
	public void deleteDepById(int depId) {
		depRepository.deleteById(depId);
		
	}

	@Override
	public List<Departement> getAlldep() {
		return (List<Departement>) depRepository.findAll();
	}






	
	
	
}