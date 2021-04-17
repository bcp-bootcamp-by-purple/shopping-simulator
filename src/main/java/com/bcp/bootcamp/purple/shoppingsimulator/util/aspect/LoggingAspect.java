package com.bcp.bootcamp.purple.shoppingsimulator.util.aspect;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging execution.
 *
 * @author Ramesh Fadatare
 *
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

  //private final Logger log = LoggerFactory.getLogger(this.getClass());

  /**
   * Pointcut that matches all repositories, services and Web REST endpoints.
   */
  @Pointcut("within(@org.springframework.stereotype.Repository *)" +
    " || within(@org.springframework.stereotype.Service *)" +
    " || within(@org.springframework.stereotype.Component *)" +
    " || within(@org.springframework.web.bind.annotation.RestController *)")
  public void springBeanPointcut() {
    // Method is empty as this is just a Pointcut, the implementations are in the advices.
  }

  /**
   * Pointcut that matches all Spring beans in the application's main packages.
   */
  @Pointcut("within(com.bcp.bootcamp.purple.shoppingsimulator..*)" +
    " || within(com.bcp.bootcamp.purple.shoppingsimulator.service..*)" +
    " || within(com.bcp.bootcamp.purple.shoppingsimulator.service.formula..*)" +
    " || within(com.bcp.bootcamp.purple.shoppingsimulator.controller..*)")
  public void applicationPackagePointcut() {
    // Method is empty as this is just a Pointcut, the implementations are in the advices.
  }

  /**
   * Run around the method execution.
   * @param joinPoint
   * @return
   * @throws Throwable
   */
  @Around("applicationPackagePointcut() || springBeanPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    if (log.isDebugEnabled()) {
      log.debug("Enter: {}.{} with arguments = {}",
        joinPoint.getTarget().getClass().getSimpleName(),
        joinPoint.getSignature().getName(),
        Arrays.toString(joinPoint.getArgs()));
    }
    try {
      Object result = joinPoint.proceed();
      if (log.isDebugEnabled()) {
        log.debug("Exit: {}.{} with arguments = {}",
          joinPoint.getTarget().getClass().getSimpleName(),
          joinPoint.getSignature().getName(),
          Arrays.toString(joinPoint.getArgs()));
      }
      return result;
    } catch (IllegalArgumentException e) {
      log.error("Illegal argument: {} in {}.{}",
        Arrays.toString(joinPoint.getArgs()),
        joinPoint.getTarget().getClass().getSimpleName(),
        joinPoint.getSignature().getName());
      throw e;
    }

  }

  /**
   * Run after the method returned a result, intercept the returned result as well.
   * @param joinPoint
   * @param result
   */
  @AfterReturning(pointcut = "applicationPackagePointcut() || springBeanPointcut()", returning =
    "result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {
    log.debug("Return: {}.{} with result = {}",
      joinPoint.getTarget().getClass().getSimpleName(),
      joinPoint.getSignature().getName(),
      result);

  }

  /**
   * Advice that logs methods throwing exceptions.
   *
   * @param joinPoint join point for advice
   * @param error exception
   */
  @AfterThrowing(pointcut = "applicationPackagePointcut() || springBeanPointcut()", throwing =
    "error")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
    log.error("Exception in {}.{} with cause = {}",
      joinPoint.getTarget().getClass().getSimpleName(),
      joinPoint.getSignature().getName(),
      error.getCause() != null ? error.getCause() : "NULL");
  }
}

