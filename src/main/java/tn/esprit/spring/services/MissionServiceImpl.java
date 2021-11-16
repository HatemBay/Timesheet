package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl  implements IMissionService{

	
	

	@Autowired
	MissionRepository missionRepository;

	
	@Override
	public Mission ajouterMission(Mission mission) {
		 	missionRepository.save(mission);
		return mission;
		
	}

	@Override
	public void deleteMissionById(int missionId) {

		missionRepository.deleteById(missionId);
		
	}

	@Override
	public List<Mission> getAllMission() {

		return (List<Mission>) missionRepository.findAll();
	}

	@Override
	public Mission getMissionById(int missionId) {

		return missionRepository.findById(missionId).orElse(new Mission());
	}
}
