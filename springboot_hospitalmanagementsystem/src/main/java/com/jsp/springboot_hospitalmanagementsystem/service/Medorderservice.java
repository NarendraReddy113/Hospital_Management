

package com.jsp.springboot_hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Medorderdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Medorder;

@Service
public class Medorderservice {

	@Autowired
	private Medorderdao medorderdao;
	
	public Medorder saveMedorder(Medorder medorder,int eid) {
		return medorderdao.saveMedorder(medorder, eid);
		
	}
	
	public Medorder updateMedorder(int mid,Medorder medorder) {
		Medorder medorder2=medorderdao.getMedorderbyid(mid);
		medorder.setEncounter(medorder2.getEncounter());
		Medorder dbMedorder=medorderdao.updateMedorder(mid, medorder);
		if(dbMedorder!=null) {
			return dbMedorder;
		}else {
			return null;
		}
		
	}
	public Medorder deleteMedorder(int mid) {
		Medorder medorder=medorderdao.deleteMedorderbyid(mid);
		if(medorder!=null) {
			return medorder;
		}else {
			return null;
		}
		
	}
	public Medorder getMedorderbyid(int mid) {
		Medorder medorder=medorderdao.getMedorderbyid(mid);
		if(medorder!=null) {
			return medorder;
		}else {
			return null;
		}
		
	}
}


