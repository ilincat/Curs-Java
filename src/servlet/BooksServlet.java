package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.DbConnection;
import objects.Book;

//@WebServlet("/Books")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BooksServlet() {
		super();
		DbConnection.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		for (Book a : DbConnection.getAllBooks()) {
			out.print(gson.toJson(a));
		}
		out.flush();
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DbConnection.addBook(request.getParameter("title"), Long.parseLong(request.getParameter("authorId")),
				Integer.parseInt(request.getParameter("year")));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
