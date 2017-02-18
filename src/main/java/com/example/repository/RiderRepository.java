package com.example.repository;

import com.example.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RiderRepository extends JpaRepository<Rider,Long> {
    List<Rider> findByNombreIs(String nombre);
    List<Rider> findByNacionalidad(String nacionalidad);
    //List<Rider> findByBirthdayBefore(LocalDate birthday);

}
