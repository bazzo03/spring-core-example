/**
 * 
 */
package ar.com.bsf.courses.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author fromero
 *
 */
@Repository("generalInfoDAO")
public class GeneralInfoDAOImpl implements GeneralInfoDAO {


	public void init() {
		System.out.println("Calling init on GeneralInfoDAOImpl");
	}
	
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.GeneralInfoDAO#getNews()
	 */
	@Override
	public List<String> getNews() {
		
		List<String> news = new ArrayList<>();
		
		System.out.println("	...Connecting to Belax News server");
		news.add("Belatrix opens new office in Siria!");
		news.add("Belatrix voted as top place to work in IT industry!");
		
		return news; 
	}
	
	public void destroy() {
		System.out.println("Calling destroy on GeneralInfoDAOImpl");
	}

}
