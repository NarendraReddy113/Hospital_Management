

package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Hospitaldao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@Service
public class Hospitalservice {

	@Autowired
	private Hospitaldao hospitaldao;
	
	public ResponseEntity<Responsestructure<Hospital>> saveHospital(Hospital hospital) {
		Responsestructure< Hospital> responsestructure=new Responsestructure<>();
		responsestructure.setMessage("sucessfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(hospitaldao.saveHospital(hospital));
		return new ResponseEntity<Responsestructure<Hospital>>(responsestructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure<Hospital>> updateHospital(int hid,Hospital hospital) {
		Hospital hospital2=hospitaldao.updateHospital(hid, hospital);
		Responsestructure<Hospital> responsestructure=new Responsestructure<>();
		if(hospital2!=null) {
			responsestructure.setMessage("sucessfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hospital2);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for the hospital");
		}
		
	}
	public ResponseEntity<Responsestructure<Hospital>> deleteHospital(int hid) {
		Hospital hospital=hospitaldao.deleteHospital(hid);
		if(hospital!=null) {
			Responsestructure<Hospital> responsestructure=new Responsestructure<>();
			responsestructure.setMessage("sucessfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for the hospital");
		}
		
	}
	public ResponseEntity<Responsestructure<Hospital>> getHospitalbyid(int hid) {
		Hospital hospital=hospitaldao.getHospitalbyid(hid);
		if(hospital!=null) {
			Responsestructure<Hospital> responsestructure=new Responsestructure<>();
			responsestructure.setMessage("sucessfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
	public ResponseEntity<Responsestructure<Hospital>> gethospitalbyemail(String email) {
		Hospital hospital=hospitaldao.gethospitalbyemail(email);
		if(hospital!=null) {
			Responsestructure<Hospital> responsestructure=new Responsestructure<>();
			responsestructure.setMessage("sucessfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure,HttpStatus.FOUND);

		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}


