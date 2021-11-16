package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	
	public Mission ajouterMission(Mission mission);
	public void deleteMissionById(int entrepriseId);
	
	public Mission getMissionById(int missionId);
	public List<Mission> getAllMission();

}
