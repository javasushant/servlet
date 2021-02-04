package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {

	@Resource(name = "DsJndi")
	private DataSource ds;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String INSERT_PERSON_PROFILE = "INSERT INTO PERSON_PROFILE VALUES(PID_SEQ.NEXTVAL,?,?,?,?)";
		String resumeLocation = "E:/upload/resumes/";
		String photoLocation = "E:/upload/photos/";
		// get printWriter
		PrintWriter pw = res.getWriter();
		// set Content type
		res.setContentType("text/html");

		String name = null, addrs = null, resumeFilePath = null, photoFilePath = null;
		boolean uploadFlag = false;
		try {
			// create Special request object which holds data and uploaded file
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
			// read form data
			name = nreq.getParameter("name");
			addrs = nreq.getParameter("addrs");
			// specify upload location in server mCHINE FILE system
			UploadBean upb = new UploadBean();
			
			// file uploading location rstriction
			upb.setMaxfiles(5);
			//upb.setFilesizelimit(10*1024);
			upb.setOverwrite(true);
			//upb.setBlacklist("instal.exe,setup.exe,abc.exe");
			
			upb.setFolderstore(resumeLocation); // uploading location in server
			upb.store(nreq, "resume"); // completes resume uploading
			
			upb.setFolderstore(photoLocation); // completes resume uploading
			upb.store(nreq, "photo"); // completes resume uploading
			
			// get all uploaded filesnames
			Vector vector = upb.getHistory();
			// get uploaded file names
			resumeFilePath = resumeLocation + ((UploadParameters) vector.get(0)).getFilename();
			photoFilePath = photoLocation + ((UploadParameters) vector.get(1)).getFilename();
			pw.println("<br><b>" + ((UploadParameters) vector.get(0)).getFilename() + "  "
					+ ((UploadParameters) vector.get(1)).getFilename() + "files are uploaded</b>");
		} catch (Exception e) {
			pw.println("<h1><b> Problems in file uploading..." + e.getMessage() + "<b></h1>");
			e.printStackTrace();
		}
		try (Connection con = ds.getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(INSERT_PERSON_PROFILE)) {
				// set value for query param
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setString(3, resumeFilePath);
				ps.setString(4, photoFilePath);
				
				// process the query
				int result = ps.executeUpdate();
				
				// process the result
				if (result == 0)
					pw.println("<h1 style='color:red;text-align:center'> Registration not completed </h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'> Registration  completed </h1>");
			}
		} // try1
		catch (Exception e) {
			pw.println("<h1 style='color:red;text-align:center'> Problem Person Registration</h1>");
			e.printStackTrace();
		}
		// add home hyperlink
		pw.println("<br><br><a href = 'upload.html'>HOME</a>");
		// close stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
