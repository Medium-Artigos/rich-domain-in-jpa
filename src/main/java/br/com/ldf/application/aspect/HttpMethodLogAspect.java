package br.com.ldf.application.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class HttpMethodLogAspect {

    /**
     * Method to log the execution of HTTP methods.
     * For proper functionality, methods must be annotated with @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping, or @GetMapping.
     *
     * @param joinPoint execution point of the method
     * @return Object returned by the method. (Best practice is to return a ResponseEntity)
     */
    @Around("(@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
        "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
        "@annotation(org.springframework.web.bind.annotation.PatchMapping) || " +
        "@annotation(org.springframework.web.bind.annotation.DeleteMapping) || " +
        "@annotation(org.springframework.web.bind.annotation.GetMapping))")
    public Object logExecutionHttpMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        log.info("stage=init-{}, method={}, controller={}, parameters={}",
            joinPoint.getSignature().getName(),
            joinPoint.getSignature().getName(),
            joinPoint.getSignature().getDeclaringType().getSimpleName(),
            joinPoint.getArgs());

        // Execute intercepted method
        Object result = joinPoint.proceed();

        long timeElapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        log.info("stage=finish-{}, method={}, controller={}, parameters={}, result={}, time-execution={}ms",
            joinPoint.getSignature().getName(),
            joinPoint.getSignature().getName(),
            joinPoint.getSignature().getDeclaringType().getSimpleName(),
            joinPoint.getArgs(),
            result,
            timeElapsed);

        return result;
    }
}
