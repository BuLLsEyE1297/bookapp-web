package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookapp.dao.AuthorDAO;
import com.chainsys.bookapp.dao.RegisterDAO;
import com.chainsys.bookapp.model.Author;
import com.chainsys.bookapp.model.RegisterClass;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.print(email);
		out.print(password);
		if (email.equalsIgnoreCase("admin@gmail.com")
				&& password.equalsIgnoreCase("admin")) {

			out.println("success");

			ArrayList<Author> arrayList;
			try {
				arrayList = AuthorDAO.authorselect();
				

				request.setAttribute("AUTHOR", arrayList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// RequestDispatcher dispatcher = request
			// .getRequestDispatcher("addbook.jsp");
			// dispatcher.forward(request, response);

			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		} else {
			try {
				RegisterClass registerClass = RegisterDAO.search(email, password);
				if (registerClass.id > 0) {
					RequestDispatcher rd = request
							.getRequestDispatcher("search.html");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("login1.html");
					rd.forward(request, response);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
