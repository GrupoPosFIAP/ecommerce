package br.com.fiap.rest.configuration.api.security.filter;

import br.com.fiap.rest.configuration.api.exception.GenericMessage;
import br.com.fiap.rest.configuration.api.exception.InvalidAuthenticationException;
import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import br.com.fiap.rest.configuration.api.security.token.JWTUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.IOException;

@Component
@Order(1)
public class RequiredAuthFilter extends OncePerRequestFilter {

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    private RequestMappingHandlerMapping reqMap;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            jwtUtils.validateToken(request.getHeader("Authorization"));
        } catch (InvalidAuthenticationException invalidAuthenticationException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter()
                    .write(convertObjectToJson(new GenericMessage(invalidAuthenticationException.getErrorCode(),
                            invalidAuthenticationException.getErrorMessage())));
            return;
        }
        filterChain.doFilter(request, response);
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        HandlerMethod method = null;
        try {
            method = (HandlerMethod) reqMap.getHandler(request).getHandler();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(method == null) {
            return false;
        }
        return !method.getMethod().isAnnotationPresent(AuthenticationRequired.class);
    }
}
