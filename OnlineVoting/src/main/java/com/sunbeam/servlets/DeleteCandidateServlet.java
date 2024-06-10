package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;

@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String idStr = req.getParameter("id");
			int id = Integer.parseInt(idStr);
			try(CandidateDao canDao = new CandidateDaoImpl()) {
				int count = canDao.deleteById(id);
				RequestDispatcher rd = req.getRequestDispatcher("result");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
}
