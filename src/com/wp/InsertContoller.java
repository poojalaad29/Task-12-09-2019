package com.wp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertContoller")
public class InsertContoller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao=new BookDAO();
		String code=request.getParameter("code");
		String title=request.getParameter("title");
		String price=request.getParameter("price");
		String author=request.getParameter("author");
		String subject=request.getParameter("subject");
		
		Book b=new Book();
		b.setCode(Integer.parseInt(code));
		b.setTitle(title);
		b.setPrice(Integer.parseInt(price));
		b.setAuthor(author);
		b.setSubject(subject);
   
		dao.saveBook(b);
		Book book=dao.searchBook(Integer.parseInt(code));
		request.setAttribute("bookinfo", book);
	
		RequestDispatcher rd=request.getRequestDispatcher("Detail.jsp");
		rd.forward(request, response);
	}

	
}
