package ar.com.bsf.courses.spring.dao;

import java.util.List;

import ar.com.bsf.courses.spring.entities.Author;

public interface AuthorDAO {

	/* 
	 * return an author by id
	 */
	Author getAuthorById(Long id);

	/*
	 * return the number total of authors
	 */
	int getTotalOfAuthors();

	/*
	 * return the total number or authors with x first name
	 */
	int getTotalOfAuthorsByName(String firstName);

	/*
	 * return the list of authors with x first name
	 */
	List<Author> getAuthorsByName(String firstName);

	/* 
	 * save an author
	 */
	Author save(Author author);

	/**
	 * update same first name for all authors
	 * 
	 */
	int[] updateSameFirstNameForAllAuthors(List<Author> authors);

	int[] updateSameFirstNameForAllAuthorsWithNamedParameter(List<Author> authors);

}