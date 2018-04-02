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
@Repository("optionalInfoDAO")
public class OptionalInfoDAOBuenaOndaImpl implements OptionalInfoDAO {

	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.CurrencyInfoDAO#getInfoForLocation()
	 */
	@Override
	public String getOptionalInfoForLocation() {
		System.out.println("	...Connecting to nice travel web provider");
		Locale loc = Locale.getDefault();
		return "THERES' SO MUCHH to visit in " + loc.getDisplayName();
	}

}
