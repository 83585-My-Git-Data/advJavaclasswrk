package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		try(UserDao userDao = new UserDaoImpl()){
			User user = userDao.findByEmail(email);
			if(user != null && user.getPassword().equals(passwd)) {
				//login Successful
				
				Cookie c = new Cookie ("uname", user.getFirstName());
				c.setMaxAge(3600);
				resp.addCookie(c);
				
				HttpSession session = req.getSession();
				session.setAttribute("curuser", user);
				
				System.out.println("Login Successful");
				if(user.getRole().equals("voter")) { 
					resp.sendRedirect("candlist");
			
				}
				else { 
					resp.sendRedirect("result");
				}
				
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Invalid email or password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
