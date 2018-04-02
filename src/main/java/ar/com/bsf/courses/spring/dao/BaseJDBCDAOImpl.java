/**
 * 
 */
package ar.com.bsf.courses.spring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author fromero
 *
 */
public class BaseJDBCDAOImpl {

	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;



	/**
	 * 
	 */
	public BaseJDBCDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}