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
@Repository("optionalInfoDAOImpl")
public class OptionalInfoDAOImpl implements OptionalInfoDAO {

	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.CurrencyInfoDAO#getInfoForLocation()
	 */
	@Override
	public String getOptionalInfoForLocation() {
		System.out.println("	...Connecting to travel web provider");
		Locale loc = Locale.getDefault();
		return "Nothing to visit in " + loc.getDisplayName();
	}

}
