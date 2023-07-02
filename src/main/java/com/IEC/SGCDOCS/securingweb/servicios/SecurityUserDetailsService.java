package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.UsuarioVisualizacion;
import com.IEC.SGCDOCS.securingweb.modelos.DB.Attempts;
import com.IEC.SGCDOCS.securingweb.modelos.DB.User;
import com.IEC.SGCDOCS.securingweb.repositorio.AttemptsRepository;
import com.IEC.SGCDOCS.securingweb.repositorio.UserRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired private AttemptsRepository attemptsRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException("User not present"));
        return user;

    }

    public List<UsuarioVisualizacion> getAllUserVis(){
        List<User> tmpListUsuarios =userRepository.findAll();
        List<UsuarioVisualizacion> lista=  tmpListUsuarios.stream()
        .map(usr->new UsuarioVisualizacion(usr.getUsername(), usr.getRoles(),usr.isAccountNonLocked()))
        .collect(Collectors.toList());
                
        return lista;

    }

    public List<Attempts> getAllAttemps(){

        return attemptsRepository.findAll();
    }

    public void enableUser(User user){
        user.setAccountNonLocked(true);
        userRepository.save(user);
    }

    public void deleteAttemp(String username){

        Optional<Attempts> attemp = attemptsRepository.findAttemptsByUsername(username);
        if (!attemp.isEmpty()) {
            Attempts attempToDel=attemp.get();
            attemptsRepository.deleteById(attempToDel.getId());
        }
        Optional<User> user = userRepository.findUserByUsername(username);
        if (!user.isEmpty())
            enableUser(user.get());



    }

    public void deleteAllAttemps(){
        attemptsRepository.deleteAll();
    }

    public void createUser(UserDetails user){
        userRepository.save((User) user);
    }
}
