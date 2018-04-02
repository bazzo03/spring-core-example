/**
 * 
 */
package ar.com.bsf.courses.spring.dao;

import java.util.Locale;

import org.springframework.stereotype.Repository;

/**
 * @author fromero
 *
 */
@Repository("weatherInfoDAO")
public class WeatherInfoDAOImpl implements WeatherInfoDAO {

	/**
	 * 
	 */
	public WeatherInfoDAOImpl() {
	
	}
	
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.WeatherInfoDAO#getInfoForLocation()
	 */
	@Override
	public String getInfoForLocation() {
		System.out.println("	...Connecting to weather forecast web provider");		
		Locale loc = Locale.getDefault();
		return "Weather for " + loc.getDisplayCountry() + " is windy with many bugs on the horizon";	
		
	}

}
