package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements IStudentDAO {
	private static final String INSERT_LAYERED_STUDENT ="INSERT INTO LAYERED_STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?,?,?)";
	
	private DataSource ds;
	
	public StudentDAOImpl() throws Exception{
		System.out.println("StudentDAOImpl. connection pool");
		//create InitialContext for making Jndi registry
		InitialContext ic = new InitialContext();
		// find a DataSource ref in jndi by lookup 
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
	}
	
	@Override
	public int insert(StudentBO bo) throws Exception {
		//get pool connection obj
		Connection con= getPooledConnection();
		//make a preparedStatement
		PreparedStatement ps = con.prepareStatement(INSERT_LAYERED_STUDENT);
		//set value to query param
		ps.setString(1, bo.getSname());
		ps.setString(2, bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		//execute the query
		int result = ps.executeUpdate();
		//close jdbc obj
		ps.close();
		con.close();
		
		return result;
	}
	private Connection getPooledConnection() throws Exception{
		//get a pooled jdbc con object through DataSource obj ref
		Connection con= ds.getConnection();
		return con;
	}
}
