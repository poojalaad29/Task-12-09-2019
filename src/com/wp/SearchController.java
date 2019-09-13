package com.wp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reads the request
		int code=Integer.parseInt(request.getParameter("code"));
	//process it using dao/service classes
		BookDAO dao=new BookDAO();
		Book book=dao.searchBook(code);
		request.setAttribute("bookinfo", book);
	
		RequestDispatcher rd=request.getRequestDispatcher("Detail.jsp");
		rd.forward(request, response);
	
	}

}
