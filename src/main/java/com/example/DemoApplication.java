package com.example;

import com.example.service.RiderService;
import com.example.service.MedallaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
        basePackageClasses = {DemoApplication.class, Jsr310JpaConverters.class}
)

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        RiderService riderService = context.getBean(RiderService.class);
        MedallaService medallaService = context.getBean(MedallaService.class);
        riderService.testRiders();
        medallaService.testMedallas();
    }
}
