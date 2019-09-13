package com.wp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao=new BookDAO();
		String code=request.getParameter("code");
		Book b=dao.DeleteBook(Integer.parseInt(code));
		request.setAttribute("bookinfo", b);
		
		RequestDispatcher rd=request.getRequestDispatcher("Detail.jsp");
		rd.forward(request, response);

	}
	}

