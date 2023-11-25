
package com.jsp.springboot_hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Meditemsdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Meditems;

@Service
public class Meditemsservice {

	@Autowired
	private Meditemsdao meditemsdao;
	
	public Meditems saveMeditems(Meditems meditems,int mid) {
		return meditemsdao.saveMeditems(meditems, mid);
		
	}
	public Meditems updateMeditems(int id,Meditems meditems) {
		Meditems meditems2=meditemsdao.getMeditemsbyid(id);
		meditems.setMedorder(meditems2.getMedorder());
		Meditems dbMeditems=meditemsdao.updateMeditems(id, meditems);
		if(dbMeditems!=null) {
			return dbMeditems;
		}else {
			return null;
		}
		
	}
	public Meditems deleteMeditems(int id) {
		Meditems meditems=meditemsdao.deleteMeditems(id);
		if(meditems!=null) {
			return meditems;
		}else {
			return null;
		}
		
	}
	public Meditems getMeditemsbyid(int id) {
		Meditems meditems=meditemsdao.getMeditemsbyid(id);
		if(meditems!=null) {
			return meditems;
		}else {
			return null;
		}
		
	}
}



