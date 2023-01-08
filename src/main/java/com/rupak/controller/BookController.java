package com.rupak.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rupak.model.Book;
import com.rupak.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@GetMapping()
	@ApiOperation(value = "find all the books") //swagger annotation for api documentation
	public List<Book> getAllBooks(){
		log.info("Entering getAllBooks() method of BookController");
		log.info("Exiting getAllBooks() method of BookController");
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "find book by id", response = Book.class)
	public Book getBookById(@PathVariable int id){
		System.out.println("id : "+id);
		return bookService.getBookById(id);
	}
	
	@PostMapping()
	@ApiOperation(value = "add a new book", notes = "returns newly added book as response", response = Book.class)
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping()
	@ApiOperation(value = "update a book", notes = "returns the updated book", response = Book.class)
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "delete book by id", response = String.class)
	public String deleteBook(@PathVariable int id) {
		String message = "Book with id = "+id+" deleted.";
		bookService.deleteBook(id);
		return message;
	}
	
	
}
