package com.rupak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Description of the Book Resource") // swagger annotation
@Entity
@Table(name = "book")
@Data @NoArgsConstructor @AllArgsConstructor
public class Book {
	
	@ApiModelProperty(notes = "Unique id for each book") // swagger annotation
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ApiModelProperty(notes = "Name of the book") // swagger annotation
    @Column(name = "book_name", length = 200)
    private String bookName;
    
	@ApiModelProperty(notes = "Name of the Author") // swagger annotation
    @Column(name = "author", length = 100)
    private String author;
    
	@ApiModelProperty(notes = "Category name of the book") // swagger annotation
    @Column(name = "category", length = 100)
    private String catetory;
}
