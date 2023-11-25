


package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Addressdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Address;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;

@Service
public class Addressservice {

	@Autowired
	private Addressdao addressdao;
	
	public Address saveAddress(Address address) {
		return addressdao.saveAddress(address);
		
	}
	
	public Address updateAddress(int aid,Address address) {
		Address address2=addressdao.updateAddress(aid, address);
		if(address2!=null) {
			return address2;
		}else {
			throw new Idnotfound("id not found for address");
		}
		
	}
	public Address deleteAddress(int aid) {
		Address address=addressdao.deleteAddress(aid);
		if(address!=null) {
			return address;
		}else {
			throw new Idnotfound("id not found for address");

		}
		
	}
	public Address getAddressbyid(int aid) {
		Address address=addressdao.getaddressbyid(aid);
		if(address!=null) {
			return address;
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}


