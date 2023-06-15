package com.IEC.SGCDOCS.securingweb.repositorio;

import com.IEC.SGCDOCS.securingweb.modelos.DB.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findUserByUsername(String username);

}
