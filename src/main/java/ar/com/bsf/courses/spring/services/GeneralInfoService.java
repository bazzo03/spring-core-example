/**
 * 
 */
package ar.com.bsf.courses.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.com.bsf.courses.spring.dao.GeneralInfoDAO;

/**
 * @author fromero
 *
 */
@Service
public class GeneralInfoService {

	@Value("${local.banner}")
	private String introLegend;
	
	@Autowired
	private GeneralInfoDAO generalInfoDAO;	
	
	
	public GeneralInfoService() {
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

	/**
	 * 
	 */
	public GeneralInfoService(GeneralInfoDAO generalInfoDAO) {
		this.generalInfoDAO = generalInfoDAO;
	}
	
	public List<String> getNews() {
		return this.generalInfoDAO.getNews();
	}	

}
