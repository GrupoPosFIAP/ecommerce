package br.com.fiap.rest.configuration.api.aspect;

import br.com.fiap.rest.configuration.api.security.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class Aspectful {

    @Autowired
    TokenService tokenService;

    @Around("@annotation(br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("passou pelo aspecto!");
        return joinPoint.proceed();
    }

}
