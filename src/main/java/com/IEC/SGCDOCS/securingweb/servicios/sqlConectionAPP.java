package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
//
//@SpringBootApplication
//public class sqlConectionAPP implements CommandLineRunner {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(sqlConectionAPP.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        String sql = "SELECT * FROM pronosticos";
//        List<Pronosticos> pronosticos = jdbcTemplate.query(sql,
//                BeanPropertyRowMapper.newInstance(Pronosticos.class));
//
//        pronosticos.forEach(System.out::println);
//    }
//
//}
