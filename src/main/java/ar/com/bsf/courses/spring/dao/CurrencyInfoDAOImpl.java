/**
 * 
 */
package ar.com.bsf.courses.spring.dao;

import java.util.Currency;
import java.util.Locale;

import org.springframework.stereotype.Repository;

/**
 * @author fromero
 *
 */
@Repository("currencyInfoDAO")
public class CurrencyInfoDAOImpl implements CurrencyInfoDAO {

	/**
	 * 
	 */
	public CurrencyInfoDAOImpl() {
	
	}
	
	/* (non-Javadoc)
	 * @see ar.com.bsf.courses.spring.dao.CurrencyInfoDAO#getInfoForLocation()
	 */
	@Override
	public String getInfoForLocation() {
		System.out.println("	...Connecting to currency exchange web provider");
		Locale loc = Locale.getDefault();
		Currency currency = Currency.getInstance(loc);
		return "USD rate exchange for " + currency.getDisplayName() + " is " + Math.random() + currency.getSymbol();
	}

}
