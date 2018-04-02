package ar.com.bsf.courses.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ar.com.bsf.courses.spring.entities.Author;
import ar.com.bsf.courses.spring.entities.Book;

@Repository("bookDAO")
public class BookDAOImpl extends BaseJDBCDAOImpl implements BookDAO {
	
	public BookDAOImpl() {
	}
		
	/* 
	 * return an Book by id
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.BookDAO#getBookById(int)
	 */
	@Override
	public Book getBookById(int id){
		return this.jdbcTemplate.queryForObject(
			"SELECT YEAR, ISBN, PAGES, TITLE, AUTHOR_ID FROM BOOK WHERE ID = ?",
			new Object[]{id},
			new RowMapper<Book>(){
				public Book mapRow(ResultSet rs, int rowNum) throws SQLException{
					Book book = new Book();
					book.setId(rs.getLong("ID"));
					book.setYear(rs.getShort("YEAR"));
					book.setIsbn(rs.getInt("ISBN"));
					book.setPages(rs.getShort("PAGES"));
					book.setTitle(rs.getString("TITLE"));
					Author aut = new Author();
					aut.setId(rs.getLong("AUTHOR_ID"));
					return book;
				}
			});
		
	}
	
	
	/* 
	 * save an Book
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.BookDAO#save(ar.com.bsf.courses.spring.entities.Book)
	 */
	@Override
	public Book save(final Book book){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(
				new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException{
						PreparedStatement ps = connection.prepareStatement("INSERT INTO Book (YEAR, ISBN, PAGES, TITLE, AUTHOR_ID) VALUES (?, ?, ?)");
						ps.setShort(1, book.getYear());
						ps.setInt(2, book.getIsbn());
						ps.setShort(3, book.getPages());
						ps.setString(4, book.getTitle());
						return ps;
					}
				},
				keyHolder); // keyHolder guarda el valor de la PK recién generada
		Long id = keyHolder.getKey().longValue();
		book.setId(id); // la guardo en el atributo id del autor
		return book;
	}
	
}