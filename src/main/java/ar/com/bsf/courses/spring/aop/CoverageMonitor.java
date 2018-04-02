/**
 * 
 */
package ar.com.bsf.courses.spring.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * @author fernando
 *
 */
public class CoverageMonitor {
	
	private static final Logger logger = LogManager.getLogger(CoverageMonitor.class);
	
	public void informCoverage(JoinPoint jp) {
		logger.info("COVERAGE: Informing coverage for " + jp);
		   
	}

}
