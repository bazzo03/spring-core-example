/**
 * 
 */
package ar.com.bsf.courses.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.bsf.courses.spring.dao.AuthorDAO;
import ar.com.bsf.courses.spring.dao.BookDAO;
import ar.com.bsf.courses.spring.entities.Author;
import ar.com.bsf.courses.spring.entities.Book;

/**
 * @author fromero
 *
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorDAO authorDAO;
	
	@Autowired
	private BookDAO bookDAO;
	
	public AuthorService() {
	}
	/**
	 * 
	 */
	public AuthorService(AuthorDAO authorDAO, BookDAO bookDAO) {
		this.authorDAO = authorDAO;
		this.bookDAO = bookDAO;
	}
	
	@Transactional
	public Author save(Author author) {
		return this.authorDAO.save(author);
	}
	
	@Transactional
	public Book saveWithBook(Author author, Book book) {
		Author aut = this.authorDAO.save(author);
		book.setAuthor(aut);
		return this.bookDAO.save(book);		
	}

}
