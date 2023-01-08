package com.rupak.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupak.model.Book;
import com.rupak.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		try {
			return (List<Book>) bookRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public Book addBook(Book book) {
		try {
			return bookRepository.save(book);
		} catch (Exception e) {
			return new Book();
		}
	}

	@Override
	public Book getBookById(int id) {
		try {
			Optional<Book> books = bookRepository.findById(Long.valueOf(String.valueOf(id)));
			return books.get();
		} catch (Exception e) {
			return new Book();
		}
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(int id) {
		 bookRepository.deleteById(Long.valueOf(String.valueOf(id)));
	}
	
	
}
