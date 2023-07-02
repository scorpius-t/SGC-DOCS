package com.IEC.SGCDOCS.securingweb.config;

import com.IEC.SGCDOCS.securingweb.modelos.UsuarioVisualizacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        UsuarioVisualizacion usrAuth = new UsuarioVisualizacion(authentication.getName(),
                authentication.getAuthorities().toString(),true);

        String redirectURL = request.getContextPath();
        System.out.println(usrAuth.toString());


        if (usrAuth.getRole().contains("ADMIN")) {
            redirectURL = "administrator.html";
                } else  {
            redirectURL = "index.html";
        }

        response.sendRedirect(redirectURL);

    }

}