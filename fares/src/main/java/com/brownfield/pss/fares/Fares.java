package com.brownfield.pss.fares;

import com.brownfield.pss.fares.model.Fare;
import com.brownfield.pss.fares.repository.FaresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static com.google.common.collect.Lists.newArrayList;

@SpringBootApplication
@Slf4j
public class Fares implements CommandLineRunner {

    @Autowired
    private FaresRepository faresRepository;

    @Autowired
    private HealthIndicator faresHealthIndicator;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Fares.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        initDB();
        doHealthCheck();
    }

    private void doHealthCheck() {
        Health health = faresHealthIndicator.health();
        if (health.getStatus().equals(Status.DOWN)) {
            applicationContext.close();
        }
    }

    private void initDB() {
        faresRepository.save(newArrayList(
                new Fare("BF100", "22-JAN-16", "101"),
                new Fare("BF101", "22-JAN-16", "101"),
                new Fare("BF102", "22-JAN-16", "102"),
                new Fare("BF103", "22-JAN-16", "103"),
                new Fare("BF104", "22-JAN-16", "104"),
                new Fare("BF105", "22-JAN-16", "105"),
                new Fare("BF106", "22-JAN-16", "106")
        ));
    }

}
