package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.DbConnection;
import objects.Author;

/**
 * Servlet implementation class Authors
 */
//@WebServlet("/Authors")
public class Authors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Authors() {
		super();
		DbConnection.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		for (Author a : DbConnection.getAllAuthors()) {
			out.print(gson.toJson(a));
		}
		out.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DbConnection.addAuthor(request.getParameter("firstName"), request.getParameter("lastName"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
