/**
 * 
 */
package ar.com.bsf.courses.spring.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fernando
 *
 */
@Aspect
@Component
public class CoverageMonitor {

	private static final Logger logger = LogManager.getLogger(CoverageMonitor.class);

	@Pointcut("public * ar.com.bsf.courses.spring.services..*(..))")
	public void informCoverage(JoinPoint jp) {
		logger.info("COVERAGE: Informing coverage for " + jp);
	}

}
