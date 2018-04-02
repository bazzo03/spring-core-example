package ar.com.bsf.courses.spring.dao;

import ar.com.bsf.courses.spring.entities.Book;

public interface BookDAO {

	/* 
	 * return an Book by id
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.BookDAO#getBookById(int)
	 */
	Book getBookById(int id);

	/* 
	 * save an Book
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.BookDAO#save(ar.com.bsf.courses.spring.entities.Book)
	 */
	Book save(Book book);

}