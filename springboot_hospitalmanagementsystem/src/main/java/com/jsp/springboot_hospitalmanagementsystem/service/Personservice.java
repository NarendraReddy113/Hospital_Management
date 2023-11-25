

package com.jsp.springboot_hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Persondao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Person;

@Service
public class Personservice {

	@Autowired
	private Persondao persondao;
	
	public Person savePerson(Person person) {
		return persondao.savePerson(person);
		
	}
	public Person updatePerson(int pid,Person person) {
	Person	person2=persondao.updatePerson(pid, person);
	if(person2!=null) {
		return person2;
	}else {
		return null;
	}
		
	}
	public Person deletePerson(int pid) {
		 Person person=persondao.deletePerson(pid);
		 if(person!=null) {
			 return person;
		 }else {
			 return null;
		 }
		
	}
	public Person getPersonbyid(int pid) {
		Person person=persondao.getPersonbyid(pid);
		if(person!=null) {
			return person;
		}else {
			return null;
		}
		
	}
}


