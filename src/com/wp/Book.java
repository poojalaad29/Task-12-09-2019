package com.wp;

public class Book {
	private int code;
	private String title;
	private int price;
	private String author;
	private String subject;
	
	
	public Book() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getPrice() {
		System.out.println(price);
		return price;
		
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Book(int code, String title, int price, String author, String subject) {
		super();
		this.code = code;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [code=" + code + ", title=" + title + ", price=" + price+",author=" + author + ", subject=" + subject + "]";
	}


}
