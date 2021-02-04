package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.IOUtils;


@WebServlet("/downloadurl")
public class FileDownloadservlet extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read additional req param value
		int id= Integer.parseInt(req.getParameter("id"));
		String type=req.getParameter("type");
		//decide the sql Query to get file to download location from Db table column
		String query=null;
		if(type.equalsIgnoreCase("resume"))
			query="SELECT RESUME FROM PERSON_PROFILE WHERE PID=?";
		else
			query="SELECT PHOTO FROM PERSON_PROFILE WHERE PID=?";
		
		//get pooled connection
		String filepath =null;
		try(Connection con = ds.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(query)){
				//set value to query param
				ps.setInt(1, id);
				//execute the query
				try(ResultSet rs = ps.executeQuery()){
					//procss the result
					if(rs.next())
						filepath = rs.getString(1);
				}//try3
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//write file downloading (resources downloading logic)
		try {
			//create java.io.file obj pointing toFTBD(FILETOBEDOWNLOADED)
			File file =new File(filepath);
			//get the length of FTBD and make it response content length
			res.setContentLengthLong(file.length());
			ServletContext sc = getServletContext();
			String mimeType = sc.getMimeType(filepath);
			mimeType = (mimeType==null)?"application/octet-stream":mimeType;
			res.setCharacterEncoding(mimeType);
			//InputStream pointing to FTBD
			InputStream is = new FileInputStream(file);
			//create outPutStream pointing to response obj
			ServletOutputStream sos= res.getOutputStream();
			//add response header content-Disposition having value 'attachment' for downloading the file
			res.addHeader("Content-Disposition", "attachment;fileName="+file.getName());
			//copy FTBD content to response object
			IOUtils.copy(is, sos);
			//close stream
			is.close();
			sos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet(-)

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
