package com.example.service;

import com.example.domain.Rider;
import com.example.repository.RiderRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private MedallaRepository medallaRepository;

    public void testRiders() {

        Rider alberto = new Rider("Alberto", "Comuñas", "Spain", LocalDate.of(1988, 9, 2));
        riderRepository.save(alberto);
        Rider sergio = new Rider("Sergio", "Díaz", "Italy", LocalDate.of(1992, 1, 20));
        riderRepository.save(sergio);
        Rider pepe = new Rider("Josep", "Manrique", "Catalonia", LocalDate.of(1992, 1, 25));
        riderRepository.save(pepe);
        Rider pol = new Rider("Pol", "Rodriguez", "Japan", LocalDate.of(1991, 1, 20));
        riderRepository.save(pol);
        Rider hector = new Rider("Hector", "Fuster", "Canada", LocalDate.of(1990, 1, 20));
        riderRepository.save(hector);

        System.out.println(riderRepository.findByNombreIs("Alberto"));
    }
}
