package com.IEC.SGCDOCS.securingweb.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired private LoginSuccessHandler loginSuccessHandler;
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/media/**", "/css/**").permitAll()
//                            .requestMatchers("/admin/**").hasRole("ADMIN")

//                            .requestMatchers(HttpMethod.DELETE).authenticated()
//                            .requestMatchers(HttpMethod.POST).authenticated()
                            .anyRequest().authenticated()
                    )
                    .formLogin((form) -> form
                            .loginPage("/login")
                            .defaultSuccessUrl("/index.html")
                                    .successHandler(loginSuccessHandler)
                            .permitAll()
                    )
                    .logout((logout) -> logout

                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/login")
                            .invalidateHttpSession(true)
                            .clearAuthentication(true)
                            .permitAll()
                    );

            return http.build();
        }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//        public UserDetailsService userDetailsService(){
//
//
//
//            EN MEMORIA
//            UserDetails user =
//                    User.withDefaultPasswordEncoder()
//                            .username("user")
//                            .password("password")
//                            .roles("USER")
//                            .build();
//
//            return new InMemoryUserDetailsManager(user);
//        }
}

