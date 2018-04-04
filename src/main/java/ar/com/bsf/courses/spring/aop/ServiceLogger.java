/**
 * 
 */
package ar.com.bsf.courses.spring.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fernando
 *
 */
@Aspect
@Component
public class ServiceLogger {

	private static final Logger logger = LogManager.getLogger(ServiceLogger.class);

	@Pointcut("execution(public * ar.com.bsf.courses.spring.services..*(..))")
	public void pointCut() {
	}

	@Around("pointCut()")
	public Object doAuditLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("AUDITING: " + pjp);
		logger.info("AUDITING ARGS: ");
		for (Object argM : pjp.getArgs()) {
			logger.info(argM.toString());
		}

		Object retVal = pjp.proceed();

		logger.info("AUDITING RETVAL: " + retVal);

		return retVal;

	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void doErrorLog(Throwable ex) {
		logger.error("HOUSTON WE HAVE A PROBLEM: " + ex);
	}

}
