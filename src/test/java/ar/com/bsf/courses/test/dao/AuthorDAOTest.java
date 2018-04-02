/**
 * 
 */
package ar.com.bsf.courses.test.dao;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import ar.com.bsf.courses.spring.dao.AuthorDAO;
import ar.com.bsf.courses.spring.entities.Author;

/**
 * @author fernando
 *
 */
@ContextConfiguration
(
		  {
		   "classpath:beans.xml",
		 
	
		  }
		
)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class AuthorDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	
	@Autowired
	private AuthorDAO authorDAO;
	
	/**
	 * Test method for {@link ar.com.bsf.courses.spring.dao.AuthorDAOImpl#getAuthorById(int)}.
	 */
	@Test
	public void testGetAuthorById() {
		long autId = 1;
		Author aut = authorDAO.getAuthorById(autId);
		Assert.notNull(aut, "No author found with id " + autId);
		
		System.out.println(aut);
	}

	/**
	 * Test method for {@link ar.com.bsf.courses.spring.dao.AuthorDAOImpl#getTotalOfAuthors()}.
	 */
	@Test
	public void testGetTotalOfAuthors() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.bsf.courses.spring.dao.AuthorDAOImpl#save(ar.com.bsf.courses.spring.entities.Author)}.
	 */
	@Test
	public void testSave() {
		
		Author author = new Author();
		author.setBirthDate(Date.valueOf("1990-12-01"));
		author.setFirstName("Daniel");
		author.setLastName("Bernal");
		
		Author authorCreated = authorDAO.save(author);
		
		System.out.println("\n\n Author created id : "+authorDAO.getAuthorById(authorCreated.getId()).toString());
		
		assertEquals(authorCreated, author);
		
		Assert.notNull(authorCreated, "Is not null");
		
//		fail("Not yet implemented");
	}

}
