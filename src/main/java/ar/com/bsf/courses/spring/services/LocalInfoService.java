/**
 * 
 */
package ar.com.bsf.courses.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.com.bsf.courses.spring.dao.CurrencyInfoDAO;
import ar.com.bsf.courses.spring.dao.OptionalInfoDAO;
import ar.com.bsf.courses.spring.dao.WeatherInfoDAO;

/**
 * @author fromero
 *
 */
@Service
public class LocalInfoService {

	@Autowired
	private WeatherInfoDAO weatherInfoDAO;
	
	@Autowired
	private CurrencyInfoDAO currencyInfoDAO;
	
	@Autowired
	private Map<String,OptionalInfoDAO> optionalInfoDAO;
	
	@Value("${general.banner}")
	private String introLegend;
	
	public LocalInfoService() {
	}
	
	/**
	 * 
	 */
	public LocalInfoService(WeatherInfoDAO weatherInfoDAO, CurrencyInfoDAO currencyInfoDAO) {
		this.weatherInfoDAO = weatherInfoDAO;
		this.currencyInfoDAO = currencyInfoDAO;
	}
	
	/**
	 * @return the introLegend
	 */
	public String getIntroLegend() {
		return introLegend;
	}
	
	/**
	 * @param introLegend the introLegend to set
	 */
	public void setIntroLegend(String introLegend) {
		this.introLegend = introLegend;
	}

	
	public List<String> getInfoForLocation() {
		
		List<String> locInfo = new ArrayList<>();
		
		locInfo.add(this.weatherInfoDAO.getInfoForLocation());
		locInfo.add(this.currencyInfoDAO.getInfoForLocation());
		
		if(this.optionalInfoDAO != null) {
			for(OptionalInfoDAO optDAO : this.optionalInfoDAO.values()) {
				locInfo.add(optDAO.getOptionalInfoForLocation());
			}
		}
		
		return locInfo;
	}

	/**
	 * @return the optionalInfoDAO
	 */
	public Map<String,OptionalInfoDAO> getOptionalInfoDAO() {
		return optionalInfoDAO;
	}

	/**
	 * @param optionalInfoDAO the optionalInfoDAO to set
	 */
	public void setOptionalInfoDAO(Map<String,OptionalInfoDAO> optionalInfoDAO) {
		this.optionalInfoDAO = optionalInfoDAO;
	}
	
}