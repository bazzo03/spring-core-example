/**
 * 
 */
package ar.com.bsf.courses.spring.aop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author fernando
 *
 */
public class ServiceInfoHider {
	
	private static final Logger logger = LogManager.getLogger(ServiceInfoHider.class);
		
	public void doSensitiveInfoHiding(Object retVal) {
		if(retVal instanceof List<?>) {
			List<String> retValStr = (List<String>)retVal;
			for(String ret : retValStr) {
				if(ret.contains("Dubai")) {
					logger.warn("INFO HIDER: OOOPS " + ret);
				}				
			}
		}
	}

}