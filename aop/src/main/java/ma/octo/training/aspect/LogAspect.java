package ma.octo.training.aspect;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

  @Before("execution(* ma.octo.training.services.*Service.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    log.info(
        "Calling Method " + joinPoint.getSignature().getName() + " with Args " + Arrays
            .toString(joinPoint.getArgs()));
  }

  @After("execution(* ma.octo.training.services.*Service.*(..))")
  public void logAfter(JoinPoint joinPoint) {
    log.info(
        "Method " + joinPoint.getSignature().getName() + " Called with args " + Arrays
            .toString(joinPoint.getArgs()));
  }

  @AfterReturning(pointcut = "execution(* ma.octo.training.services.*Service.*(..))", returning = "result")
  public void logAfterReturn(JoinPoint joinPoint, Object result) {
    log.info(
        "Method " + joinPoint.getSignature().getName() + " Called with args " + Arrays
            .toString(joinPoint.getArgs()) + " and returned " + result);
  }

  @AfterThrowing(pointcut = "execution(* ma.octo.training.services.*Service.*(..))", throwing = "e")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
    log.info("Method " + joinPoint.getSignature().getName() + " has thrown exception " + e);
  }

  @Around("execution(* ma.octo.training.services.DemoService.handleEventWithSleep(..))")
  public Object executionTime(ProceedingJoinPoint point) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object object = point.proceed();
    long endtime = System.currentTimeMillis();
    log.info(
        "Class Name: " + point.getSignature().getDeclaringTypeName() + ". Method Name: " + point
            .getSignature().getName() + ". Time taken for Execution is : " + (endtime - startTime)
            + "ms");
    return object;
  }
}
