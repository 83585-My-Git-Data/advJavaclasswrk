package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.pojo.User;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;

public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		String candidateId = req.getParameter("candidate");
//		int id = Integer.parseInt(candidateId);
//		try(CandidateDao canDao = new CandidateDaoImpl()){
//			canDao.incrementVote(id);
//			System.out.println("Voted Successfully !!!");
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw new ServletException(e);
//		} 
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("curuser");
		int userId = user.getId();
		String message = "";
		
		if(user.getStatus() == 0) { // if user not yet voted
			String candidateId = req.getParameter("candidate");
			int id = Integer.parseInt(candidateId);
		try(CandidateDao candDao = new CandidateDaoImpl()) {
				candDao.incrementVote(id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			message = "Your vote is registerd successfully. <br/><br/>";
			// mark user as voted in db
		try(UserDao userDao = new UserDaoImpl()) {
				userDao.updateStatus(userId, true);
			} catch (Exception e) {
			e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else { // if user already voted
			message = "You have already voted. <br/><br/>";
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Online Voting</h3>");
		
		String userName = "";
		Cookie[] arr = req.getCookies();
		if(arr != null ) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname")) {
					userName = c.getValue();
				}
			}
		}
		out.printf("Hello, %s<hr/>\n", userName);
		out.println("Your vote is Registered Successfully !! <br/><br/>");
		out.println("<a href = 'logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
}
