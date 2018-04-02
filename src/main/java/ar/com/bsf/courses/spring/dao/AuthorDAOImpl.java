package ar.com.bsf.courses.spring.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ar.com.bsf.courses.spring.entities.Author;

@Repository("authorDAO")
public class AuthorDAOImpl extends BaseJDBCDAOImpl implements AuthorDAO {
	
	public AuthorDAOImpl() {
	}
		
	/* 
	 * return an author by id
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#getAuthorById(int)
	 */
	@Override
	public Author getAuthorById(final Long id){
		final DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
		
		Author author = this.jdbcTemplate.queryForObject(
			"SELECT FIRST_NAME, LAST_NAME, BIRTH_DATE FROM AUTHOR WHERE ID = ?",
			new Object[]{id},
			new RowMapper<Author>(){
				public Author mapRow(ResultSet rs, int rowNum) throws SQLException{
					Author author = new Author();
					author.setId(id);
					author.setFirstName(rs.getString("FIRST_NAME"));
					author.setLastName(rs.getString("LAST_NAME"));
					try {
						author.setBirthDate(formatter.parse(rs.getString("BIRTH_DATE")));
					} catch (ParseException e) {
					}
					return author; // return del callback
				}
			});
		return author; // obligatorio ! es el return del método en sí, o sea esta línea es obligatoria pq quizás no entra al callback y no leyó ningún return aún
	}
	
	/*
	 * return the number total of authors
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#getTotalOfAuthors()
	 */
	@Override
	public int getTotalOfAuthors(){
		return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM AUTHOR", Integer.class);
	}
	
	/*
	 * return the total number or authors with x first name
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#getTotalOfAuthorsByName(java.lang.String)
	 */
	@Override
	public int getTotalOfAuthorsByName(String firstName){ // practico namedParameterJdbcTemplate
		String sql = "SELECT COUNT(*) FROM AUTHOR WHERE first_name = :first_name";
	
		Map<String, String> namedParameters = Collections.singletonMap("first_name", firstName);
				
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);		
	}
	
	/*
	 * return the list of authors with x first name
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#getAuthorsByName(java.lang.String)
	 */
	@Override
	public List<Author> getAuthorsByName(String firstName){
		List<Author> authors = this.jdbcTemplate.query(
				"SELECT first_name FROM AUTHOR WHERE first_name = ?",
				new Object[]{firstName},
				new RowMapper<Author>(){
					public Author mapRow(ResultSet rs, int rowNum) throws SQLException{
						Author authors = new Author();
						authors.setFirstName(rs.getString("FIRST_NAME"));
						return authors;
					}
				});
			return authors;
	}
	
	/* 
	 * save an author
	 */
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#save(ar.com.bsf.courses.spring.entities.Author)
	 */
	@Override
	public Author save(final Author author){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(
				new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException{
						PreparedStatement ps = connection.prepareStatement("INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (?, ?, ?)");
						ps.setString(1, author.getFirstName());
						ps.setString(2, author.getLastName());
						ps.setDate(3, (Date) author.getBirthDate());
						return ps;
					}
				},
				keyHolder); // keyHolder guarda el valor de la PK recién generada
		Long id = keyHolder.getKey().longValue();
		author.setId(id); // la guardo en el atributo id del autor
		return author;
	}
	
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#updateSameFirstNameForAllAuthors(java.util.List)
	 */
	@Override
	public int[] updateSameFirstNameForAllAuthors(final List<Author> authors){ // gonna practice batch here
		// batchUpdate() se usa para UPDATE, INSERT etc
		int[] updateCounts = jdbcTemplate.batchUpdate( // 
						"UPDATE AUTHOR SET FIRST_NAME = ?", // 
						new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i) throws SQLException{
								ps.setString(1, authors.get(i).getFirstName()); // i es el registro actual a modificar
							}
							public int getBatchSize() {
								return authors.size(); // 1 batch de 6 update pq mi colección tiene 6 elementos
								//return 3; // si pongo return 3; son 6/3=2, serán la cantidad de batches o sea 2 (1 batch con 3 update, otro batch con 3 update). Listo.
								// o sea con este método informo el tamaño del batch, por ej basándome en la cantidad de registros a  modificar (authors.length)
							}
						});
			System.out.println("número de registros afectados en CADA batch: " + updateCounts.length);
			return updateCounts;
	}
	
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.AuthorDAO#updateSameFirstNameForAllAuthorsWithNamedParameter(java.util.List)
	 */
	@Override
	public int[] updateSameFirstNameForAllAuthorsWithNamedParameter(final List<Author> authors){ // gonna practice batch here
		return this.namedParameterJdbcTemplate.batchUpdate( 
					"UPDATE AUTHOR SET FIRST_NAME = :firstName",
					SqlParameterSourceUtils.createBatch(authors.toArray()));
	}
	
}