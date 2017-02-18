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

        Rider alberto = new Rider("Alberto", "Comuñas", "Spain");
        riderRepository.save(alberto);
        Rider sergio = new Rider("Sergio", "Díaz", "Italy");
        riderRepository.save(sergio);
        Rider pepe = new Rider("Josep", "Manrique", "Catalonia");
        riderRepository.save(pepe);
        Rider pol = new Rider("Pol", "Rodriguez", "Japan");
        riderRepository.save(pol);
        Rider hector = new Rider("Hector", "Fuster", "Canada");
        riderRepository.save(hector);

        System.out.println(riderRepository.findByNombreIs("Alberto"));
    }
}
