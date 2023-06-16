package com.IEC.SGCDOCS.securingweb.config;



import java.util.Optional;

import com.IEC.SGCDOCS.securingweb.servicios.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Attempts;
import com.IEC.SGCDOCS.securingweb.modelos.DB.User;
import com.IEC.SGCDOCS.securingweb.repositorio.AttemptsRepository;
import com.IEC.SGCDOCS.securingweb.repositorio.UserRepository;

@Component public class AuthProvider implements AuthenticationProvider {
    private static final int ATTEMPTS_LIMIT = 3;

    @Autowired private SecurityUserDetailsService userDetailsService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AttemptsRepository attemptsRepository;
    @Autowired private UserRepository userRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user=new User();
        boolean isUsrNotFound=false;
        try {
            user = userDetailsService.loadUserByUsername(username);

        }catch (UsernameNotFoundException e){
            user.setUsername(username);
            isUsrNotFound=true;
        }
        if ((!user.isAccountNonLocked())&& !isUsrNotFound)
            throw new AuthenticationServiceException("Cuenta bloqueada. Contacte al administrador");

        if ((!(username.equals(user.getUsername()) && password.equals(user.getPassword())))||isUsrNotFound) {
            System.out.println( username + " "+ user.getUsername() + "|| "+ password + " "+ user.getPassword());

            if(!isUsrNotFound)
                processFailedAttempts(username, user);
            throw new AuthenticationServiceException("Usuario y/o contraseña invalidos");
        }

        //  Reset contador de intentos
        Optional<Attempts>
                userAttempts = attemptsRepository.findAttemptsByUsername(username);
        if (userAttempts.isPresent()) {
            Attempts attempts = userAttempts.get();
            attempts.setAttempts(0);
            attemptsRepository.save(attempts);
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities() );
    }
    private void processFailedAttempts(String username, User user) {
        Optional<Attempts>
                userAttempts = attemptsRepository.findAttemptsByUsername(username);
        if (userAttempts.isEmpty()) {
            Attempts attempts = new Attempts();
            attempts.setUsername(username);
            attempts.setAttempts(1);
            attemptsRepository.save(attempts);
        } else {
            Attempts attempts = userAttempts.get();
            attempts.setAttempts(attempts.getAttempts() + 1);
            attemptsRepository.save(attempts);

            if (attempts.getAttempts() + 1 >
                    ATTEMPTS_LIMIT) {
                user.setAccountNonLocked(false);
                userRepository.save(user);
                throw new LockedException("Demasiados intentos, se bloqueó la cuenta");
            }
        }
    }
    @Override public boolean supports(Class<?> authentication) {
        return true;
    }
    }