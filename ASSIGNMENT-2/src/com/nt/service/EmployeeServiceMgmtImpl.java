package com.nt.service;

import com.nt.bo.EmplyoeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.IEmplyoeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {
	private IEmplyoeeDAO dao;
	
	
	public EmployeeServiceMgmtImpl() throws Exception{
		dao = new EmployeeDAO();
	}


	@Override
	public String getService(EmployeeDTO dto) throws Exception {
		//b.logic
		float grossSal = dto.getBasicSal()+dto.getHra();
		String result =null;
		//generate salary
		if(dto.getBasicSal()<10000 || dto.getHra()<5000)
			result = "Lower middle";
		else
			result = "High class";
		
		
		//create BO class obj
		EmplyoeeBO bo= new EmplyoeeBO();
		bo.setEname(dto.getEname());
		bo.setEadd(dto.getEadd());
		bo.setBasicSal(dto.getBasicSal());
		bo.setGrossSal(grossSal);
		
		// use dao class
		int count = dao.result(bo);
		return count==0?"Result is not submitted in Db":"Result is submitted successfully";
	}
}
