package com.rupak.service;

import java.util.List;

import com.rupak.model.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public Book getBookById(int id);
	public Book updateBook(Book book);
	public void deleteBook(int id);

}
