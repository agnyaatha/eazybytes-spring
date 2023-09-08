package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private Logger logger = Logger.getLogger( LoggerAspect.class.getName() );

    @Around("execution(* com.example.service.*.*(..))")
    public void log( ProceedingJoinPoint proceedingJoinPoint ) throws Throwable{
        logger.info( proceedingJoinPoint.getSignature().toString() + " -> method execution started" );
        Instant start = Instant.now();
        proceedingJoinPoint.proceed();
        Instant finsih = Instant.now();
        long timeElapsed = Duration.between( start, finsih ).toMillis();
        logger.info( "Time elapsed = " + timeElapsed );
        logger.info( proceedingJoinPoint.getSignature().toString() + " -> method execution end" );
        logger.info("-------------------------------------------------------------------------------");
    }

    @Around("@annotation(com.example.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        logger.info( proceedingJoinPoint.getSignature().toString() + " -> method execution started" );
        Instant start = Instant.now();
        proceedingJoinPoint.proceed();
        Instant stop = Instant.now();
        long timeElapsed = Duration.between( start, stop ).toMillis();
        logger.info("Time elapsed = " + timeElapsed);
        logger.info(proceedingJoinPoint.getSignature().toString() + " -> method execution end");
        logger.info("---------------------------------------------------------------------------------");
    }

    @AfterThrowing(value = "execution(* com.example.service.*.*(..))", throwing = "exception")
    public void logException( JoinPoint joinPoint, Exception exception ){
        logger.log(Level.SEVERE,joinPoint.getSignature().toString()+ " An exception thrown with the help of" +
                " @AfterThrowing which happened due to : "+exception.getMessage());
        logger.info("---------------------------------------------------------------------------------");
    }

    @AfterReturning(value = "execution(* com.example.service.*.*(..))",returning = "retVal")
    public void logStatus(JoinPoint joinPoint,Object retVal) {
        logger.log(Level.INFO,joinPoint.getSignature()+ " Method successfully processed with the status " +
                retVal.toString());
        logger.info("---------------------------------------------------------------------------------");
    }


}
