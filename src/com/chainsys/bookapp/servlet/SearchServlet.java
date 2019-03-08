package com.chainsys.bookapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bookapp.dao.BookDAO;
import com.chainsys.bookapp.model.Book;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if (!name.isEmpty()) {
			try {
				ArrayList<Book> book = BookDAO.selectBook(name);
				if (!book.isEmpty()) {
					request.setAttribute("BOOKS", book);
					RequestDispatcher rd = request
							.getRequestDispatcher("search.jsp");
					rd.forward(request, response);
				} else {
					response.getWriter().print("No Records Found");
					RequestDispatcher rd = request
							.getRequestDispatcher("record.html");
					rd.forward(request, response);
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			response.getWriter().print("No Records Found");
			RequestDispatcher rd = request.getRequestDispatcher("record.html");
			rd.forward(request, response);

		}
	}

}
