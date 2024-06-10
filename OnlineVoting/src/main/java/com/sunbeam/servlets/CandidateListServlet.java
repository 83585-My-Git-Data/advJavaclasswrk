package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.pojo.Candidate;

public class CandidateListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	} 
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao canDao = new CandidateDaoImpl()){
			list = canDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidates</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3>Online Voting</h3>");
				
				String userName = "";
					Cookie[] arr = req.getCookies();
					if(arr != null) {
						for (Cookie c : arr) {
							if(c.getName().equals("uname")) {
								userName = c.getValue();
								break;
							}
						}
					}
						out.printf("Hello, %s<hr/>\n", userName);
				
				out.println("<form method='post' action='vote'>");
				for (Candidate c : list) {
					// <input type='radio' name='candidate' value='submit-value'/> display-label
					out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n", 
							c.getId(), c.getName(), c.getParty());
				}
				out.println("<input type='submit' value='Vote'/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
	} 
	
}
