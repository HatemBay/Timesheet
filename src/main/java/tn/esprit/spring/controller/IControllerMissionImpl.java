package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;


@Controller
public class IControllerMissionImpl {


	@Autowired
	IMissionService iMissionService;

	public int ajouterMission(Mission missionAjouter)
	{
		 Mission mission =iMissionService.ajouterMission(missionAjouter);
		return mission.getId();
	
	}
    
    @DeleteMapping("/deleteMissionById/{idmission}") 
	@ResponseBody 
	public void deleteMissionById(@PathVariable("idmission")int idmission)
	{
    	iMissionService.deleteMissionById(idmission);
	}
    
    
    @GetMapping(value = "getMissionById/{idmission}")
    @ResponseBody
	public Mission getMissionById(@PathVariable("idmission") int idmission) {

		return iMissionService.getMissionById(idmission);
	}
    
    
}
