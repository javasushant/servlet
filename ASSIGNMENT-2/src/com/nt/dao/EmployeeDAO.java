package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmplyoeeBO;

public class EmployeeDAO implements IEmplyoeeDAO {
	private static final String INSERT_QUERY = "INSERT INTO EMP_REG VALUES(EMP_SEQ.NEXTVAL,?,?,?,?)";
	private DataSource ds;
	
	public EmployeeDAO() throws Exception {
		// make a jndi registry
		InitialContext ic = new InitialContext();
		//find a SataSource obj through lookup code
		DataSource ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
				
	}

	@Override
	public int result(EmplyoeeBO bo) throws Exception {
		// write jdbc connection for DB
		Connection con = getPooledConnection();
		// amke a preparedStatement
		PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
		
		//set a query param
		ps.setString(1, bo.getEname());
		ps.setString(2, bo.getEadd());
		ps.setInt(3,bo.getBasicSal());
		ps.setFloat(4, bo.getGrossSal());
		
		//process the query
		int result = ps.executeUpdate();
		
		//close jdbc resorces
		ps.close();
		con.close();
		return result;
	}
	
	// get  a pooled connection 
	private Connection getPooledConnection() throws Exception{
		Connection con = ds.getConnection();
		return con;
	}
}
