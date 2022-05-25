package com.BIKE4USpringBoot.bike4u.apirest.Data;

import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.Controller.MotorBikeController;
import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.MotorBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dataloader {

    @Autowired
    MotorBikeController motorBikeController;

    @PostConstruct
    public void init() {
        motorBikeController.create(new MotorBike("CBR650R", "HONDA", 95));
        motorBikeController.create(new MotorBike("CBR500R", "HONDA", 47));
        motorBikeController.create(new MotorBike("CBR1000R", "HONDA", 190));
        motorBikeController.create(new MotorBike("R1", "YAMAHA", 180));
        motorBikeController.create(new MotorBike("R7", "YAMAHA", 74));
        motorBikeController.create(new MotorBike("MT07", "YAMAHA", 74));
        motorBikeController.create(new MotorBike("MT09", "YAMAHA", 120));
        motorBikeController.create(new MotorBike("RSV4", "APRILIA", 200));
        motorBikeController.create(new MotorBike("RS660", "APRILIA", 95));
        motorBikeController.create(new MotorBike("RS125", "APRILIA", 20));
        motorBikeController.create(new MotorBike("PANIGALE V4", "DUCATI", 95));
        motorBikeController.create(new MotorBike("MONSTER", "DUCATI", 110));



    }
}
