
package com.jsp.springboot_hospitalmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_hospitalmanagementsystem.dto.Person;
import com.jsp.springboot_hospitalmanagementsystem.service.Personservice;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
public class Personcontroller {

	@Autowired
	private Personservice personservice;
	
	@ApiOperation(value = "save person",notes = "api is used to save person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return personservice.savePerson(person);
		
	}
	@ApiOperation(value = "update person",notes = "api is used to update person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updated"),
			@ApiResponse(code = 404,message = "id not found")
	})
	@PutMapping
	public Person updatePerson(@RequestParam int pid,@RequestBody Person person) {
		return personservice.updatePerson(pid, person);
	}
	@ApiOperation(value = "delete person",notes = "api is used to delete person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),
			@ApiResponse(code = 404,message = "id not found")
	})
	@DeleteMapping
	public Person deletePerson(@RequestParam int pid) {
		return personservice.deletePerson(pid);
		
	}
	@ApiOperation(value = "get person by id",notes = "api is used to find the person based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),
			@ApiResponse(code = 404,message = "id not found")
	})
	@GetMapping
	public Person getPersonbyid(@RequestParam int pid) {
		return personservice.getPersonbyid(pid);
		
	}
}

