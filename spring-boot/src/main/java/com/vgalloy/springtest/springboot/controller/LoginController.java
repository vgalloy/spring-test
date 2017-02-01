package com.vgalloy.springtest.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 30/01/17.
 */
@RestController
public final class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public void login(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                      @RequestParam String username, @RequestParam String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpSession session = servletRequest.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            servletResponse.setStatus(HttpStatus.OK.value());
        } else {
            servletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public void logout(HttpServletResponse servletResponse) {
        SecurityContextHolder.clearContext();
        servletResponse.setStatus(HttpStatus.OK.value());
    }
}
