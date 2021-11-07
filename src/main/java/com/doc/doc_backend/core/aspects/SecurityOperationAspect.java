package com.doc.doc_backend.core.aspects;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.doc.doc_backend.core.annotations.SecurityOperation;
import com.doc.doc_backend.core.security.jwt.JwtHelper;
import org.apache.http.HttpHeaders;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

@Configuration
@Aspect
public class SecurityOperationAspect {
    private String headers;
    private String token;
    private HttpServletRequest request;

    @Autowired
    public SecurityOperationAspect(HttpServletRequest request) {
        this.request = request;

    }

    @Before("@annotation(com.doc.doc_backend.core.annotations.SecurityOperation)")
    public void before(JoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SecurityOperation securityAnnotation = method.getAnnotation(SecurityOperation.class);

        headers = this.request.getHeader(HttpHeaders.AUTHORIZATION);
        if (headers != null) {
            token = headers.substring("Bearer ".length());
        }

        String[] security = securityAnnotation.security();
        DecodedJWT decodedJWT = JwtHelper.decodeJwtAndGetClaims(token);

        if (decodedJWT.getExpiresAt().getTime() < System.currentTimeMillis()) {
            throw new Exception("Token is not valid");
        }

        List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
        for (String value : security) {
            if (roles.contains(value)) {
                return;

            }
        }
        throw new Exception("You have no auth");
    }
}
