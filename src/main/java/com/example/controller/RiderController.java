package com.example.controller;

import com.example.domain.Categoria;
import com.example.domain.Rider;
import com.example.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderRepository riderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rider createRider(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }

    @PutMapping
    public Rider updateRider(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }

    @GetMapping
    public List<Rider> findAll() {
        return riderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rider findById(@PathVariable Long id) {
        return riderRepository.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRider(@PathVariable Long id) {
        riderRepository.delete(id);
    }

    @GetMapping("/pais/{nacionalidad}")
    public List<Rider> findByNacionalidad(@PathVariable String nacionalidad) {
        return riderRepository.findByNacionalidad(nacionalidad);
    }

    @GetMapping("/nacidoAntesDe/{birthday}")
    public List<Rider> findByBirthdayBefore(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate birthday) {
        return riderRepository.findByBirthdayBefore(birthday);
    }

    @GetMapping("/ridersPorPais")
    public Map<String, List<Rider>> ridersByNacionalidad() {
        return riderRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(Rider::getNacionalidad));

    }

    @GetMapping("/PorCategoria")
    public Map<Categoria, List<Rider>> getRiderGroupByCategoria() {
        return riderRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(rider -> {
                    if (rider.getMedallas().stream().anyMatch(medalla -> medalla.getCategoria() == Categoria.ORO)) {
                        return Categoria.ORO;
                    } else if (rider.getMedallas().stream().anyMatch(medalla -> medalla.getCategoria() == Categoria.PLATA)) {
                        return Categoria.PLATA;
                    } else if (rider.getMedallas().stream().anyMatch(medalla -> medalla.getCategoria() == Categoria.BRONCE)) {
                        return Categoria.BRONCE;
                    } else {
                        return Categoria.VACIO;
                    }
                }));
    }
}