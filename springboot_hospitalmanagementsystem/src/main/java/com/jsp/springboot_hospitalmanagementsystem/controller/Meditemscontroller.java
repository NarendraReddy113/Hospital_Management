
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

import com.jsp.springboot_hospitalmanagementsystem.dto.Meditems;
import com.jsp.springboot_hospitalmanagementsystem.service.Meditemsservice;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.EqualsAndHashCode.Include;

@RestController
@RequestMapping("/meditems")
public class Meditemscontroller {

	@Autowired
	private Meditemsservice meditemsservice;
	
	@ApiOperation(value = "save meditems",notes = "api is used to save meditems")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public Meditems saveMeditems( @RequestBody Meditems meditems,@RequestParam int mid) {
		return meditemsservice.saveMeditems(meditems, mid);
	}
	@ApiOperation(value = "update meditems",notes = "api is used to update meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updated"),
			@ApiResponse(code = 404,message = "id not found")
	})
	@PutMapping
	public Meditems updateMeditems(@RequestParam int id,@RequestBody Meditems meditems) {
		return meditemsservice.updateMeditems(id, meditems);
		
	}
	@ApiOperation(value = "delete meditems",notes = "api is used to delete meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),
			@ApiResponse(code = 404,message = "id not found")
	})
	@DeleteMapping
	public Meditems deleteMeditems(@RequestParam int id) {
		 return meditemsservice.deleteMeditems(id);
		
	}
	@ApiOperation(value = "get meditems by id",notes = "api is used to find the meditems based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),
			@ApiResponse(code = 404,message = "id not found")
	})
	@GetMapping
	public Meditems getMeditemsbyid(@RequestParam int id) {
		return meditemsservice.getMeditemsbyid(id);
		
	}
}





