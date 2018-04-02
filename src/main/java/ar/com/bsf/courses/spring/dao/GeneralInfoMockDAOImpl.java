/**
 * 
 */
package ar.com.bsf.courses.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author fromero
 *
 */
@Repository("generalInfoMockDAO")
@Profile("test")
public class GeneralInfoMockDAOImpl implements GeneralInfoDAO {


	public List<String> getNews() {
		
		List<String> news = new ArrayList<>();
		news.add("Belatrix opens new office in Dubai!");
		news.add("Belatrix voted as coolest place to work in IT industry!");
		
		return news; 
	}

}
