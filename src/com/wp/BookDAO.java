package com.wp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDAO {

private Connection con;

	
	public void saveBook(Book book) {
		try {
			String sql = "insert into books values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, book.getCode());
			ps.setString(2, book.getTitle());
			ps.setInt(3, book.getPrice());
			ps.setString(4, book.getAuthor());
			ps.setString(5, book.getSubject());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
   public Book DeleteBook(int code) {
	   Book book=searchBook(code);
		String sql = "Delete FROM books WHERE id=?";
			PreparedStatement ps;
     	try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, code);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
     		
     	return book;

    }
	public Book searchBook(int code) {
		Book book = null;
		String sql = "SELECT * FROM books WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
		     ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				book = new Book();
				book.setCode(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setAuthor(rs.getString(4));
				book.setSubject(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	public List<Book> getAllBooks() {
		return null;
	}

	public BookDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
