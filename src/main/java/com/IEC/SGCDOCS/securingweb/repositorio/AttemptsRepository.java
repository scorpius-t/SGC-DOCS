package com.IEC.SGCDOCS.securingweb.repositorio;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Long> {
    Optional<Attempts> findAttemptsByUsername(String username);
    Optional<Attempts> findAttemptsById(long id);
}
