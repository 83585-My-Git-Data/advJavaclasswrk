package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.pojo.Candidate;
import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;

//@WebServlet("/result")
public class Resultservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Candidate> list = new ArrayList<>();
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
		out.println("<title>Result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Candidate c : list) {
			out.println("<tr>");
			out.printf("<td>%d</td>\n", c.getId());
			out.printf("<td>%s</td>\n", c.getName());
			out.printf("<td>%s</td>\n", c.getParty());
			out.printf("<td>%d</td>\n", c.getVotes());
//			out.printf("<td>%d</td>\n", c.getId());
//			out.printf("<td><a href='delcand?id=%d'><img width='24' height='24' src='images/delete.png'/></a></td>\n", c.getId());
			out.printf("<td><a href='editcand?id=%d'>Edit</a> <a href='delcand?id=%d'>Delete</a></td>\n", c.getId(), c.getId());
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
