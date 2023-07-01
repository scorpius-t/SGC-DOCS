package com.IEC.SGCDOCS.securingweb.modelos.DB;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="log_attempts")
public class Attempts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "usr", nullable = false)
    private String username;
    private int attempts;


}
