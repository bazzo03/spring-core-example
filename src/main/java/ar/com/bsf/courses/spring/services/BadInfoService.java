/**
 * 
 */
package ar.com.bsf.courses.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author fromero
 *
 */
@Service
public class BadInfoService {
	
	public List<String> getNews(boolean veryBad, boolean tremendouslyBad) {
		
		throw new RuntimeException("UNABLE TO CONNECT TO BAD NEWS SERVER!!");
	}	

}
