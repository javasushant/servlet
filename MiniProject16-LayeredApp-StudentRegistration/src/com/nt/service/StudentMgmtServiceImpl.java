package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.IStudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dao.StudentDAOImplmYSQL;
import com.nt.dto.StudentDTO;

public class StudentMgmtServiceImpl implements IStudentMgmtService {
	private IStudentDAO dao;
	
	
	public StudentMgmtServiceImpl() throws Exception {
		//dao = new  StudentDAOImpl();
		dao = new StudentDAOImplmYSQL();
	}


	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		//write b.logic
		int total = dto.getMarks1()+dto.getMarks2()+dto.getMarks3();
		//calculate avg
		float avg=total/3.0f;
		//generate result
		String result = null;
		if(dto.getMarks1()<35 ||dto.getMarks2()<35 || dto.getMarks3()<35) 
			result ="failed";
		else if(avg<35)
			result = "fail";
		else if(avg<55)
			result= "Third class";
		else if(avg<60)
			result = "Second class";
		else
			result = "first class";
		
		//create StudentBO class obj
		StudentBO bo= new StudentBO();
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		 bo.setTotal(total);bo.setAvg(avg); bo.setResult(result);
		//use DAO
		int count = dao.insert(bo);
		
		return count==0?"Student Registration Failed":"Student Registration Successful ";
	}
}
