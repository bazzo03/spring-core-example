/**
 * 
 */
package ar.com.bsf.courses.spring.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author fernando
 *
 */
public class ServiceLogger {
	
	private static final Logger logger = LogManager.getLogger(ServiceLogger.class);
	
	public Object doAuditLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("AUDITING: " + pjp);
		logger.info("AUDITING ARGS: ");
		for(Object argM : pjp.getArgs()) {
			logger.info(argM.toString());
		}
		
		Object retVal = pjp.proceed();
		
		logger.info("AUDITING RETVAL: " + retVal);
		
		return retVal;
		
	}
	
	public void doErrorLog(Throwable ex) {
		logger.error("HOUSTON WE HAVE A PROBLEM: " + ex);
	}

}
