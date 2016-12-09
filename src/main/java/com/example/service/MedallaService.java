package com.example.service;

import com.example.domain.Medalla;
import com.example.repository.MedallaRepository;
import com.example.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.domain.Categoria.*;

@Service
public class MedallaService {
    @Autowired
    private MedallaRepository medallaRepository;

    @Autowired
    private RiderRepository riderRepository;



    public void testMedallas(){

        Medalla pipe = new Medalla(ORO,"Half-Pipe", "Andorra");
        pipe.setRider(riderRepository.findOne(1L));
        medallaRepository.save(pipe);
        Medalla sloope = new Medalla(PLATA,"Slopestyle", "Barcelona");
        sloope.setRider(riderRepository.findOne(5L));
        medallaRepository.save(sloope);
        Medalla jibs = new Medalla(BRONCE,"Jibbing", "Aspen");
        jibs.setRider(riderRepository.findOne(3L));
        medallaRepository.save(jibs);
        Medalla air = new Medalla(PLATA,"Big-Air", "Alaska");
        air.setRider(riderRepository.findOne(4L));
        medallaRepository.save(air);
        Medalla quarter = new Medalla(ORO,"Quarterpipe", "Korea");
        quarter.setRider(riderRepository.findOne(1L));
        medallaRepository.save(quarter);
        Medalla free = new Medalla(ORO,"Freeride", "Suiza");
        free.setRider(riderRepository.findOne(1L));
        medallaRepository.save(free);
        Medalla cross = new Medalla(BRONCE,"Boardercross", "Noruega");
        cross.setRider(riderRepository.findOne(5L));
        medallaRepository.save(cross);


    }
}