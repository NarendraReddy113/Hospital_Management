

package com.jsp.springboot_hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Branchdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Branch;

@Service
public class Branchservice {

	@Autowired
	private Branchdao branchdao;
	
	public Branch saveBranch(Branch branch,int hid,int aid) {
		return branchdao.saveBranch(branch, hid, aid);
	}
	
	public Branch updateBranch(int bid,Branch branch) {
		Branch branch2=branchdao.updateBranch(bid, branch);
		if(branch2!=null) {
			return branch2;
		}else {
			return null;
		}
		
	}
	public Branch deleteBranch(int bid) {
		Branch branch=branchdao.deleteBranch(bid);
		if(branch!=null) {
			return branch;
		}else {
			return null;
		}
	}
	public Branch getBranchbyid(int bid) {
		Branch branch=branchdao.getBranchbyid(bid);
		if(branch!=null) {
			return branch;
		}else {
			return null;
		}
		
	}
}


