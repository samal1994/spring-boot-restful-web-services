package com.demo.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Before(value ="execution(* com.demo.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        logger.info(" Allowed execution for {}", joinPoint);
    }
    
    @AfterReturning(value = "execution(* com.demo.controller.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(value = "execution(* com.demo.controller.*.*(..))", throwing = "exception")
	public void afterTrowing(JoinPoint joinPoint, Throwable exception){
		logger.error("{} throwing exeption {}", joinPoint,exception);
	}
    
	 @After(value = "execution(* com.demo.controller.*.*(..))")
	    public void after(JoinPoint joinPoint) {
	        logger.info("after execution of {}", joinPoint);
	    }
}
