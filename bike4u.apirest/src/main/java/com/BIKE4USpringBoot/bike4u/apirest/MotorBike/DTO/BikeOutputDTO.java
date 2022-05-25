package com.BIKE4USpringBoot.bike4u.apirest.MotorBike.DTO;

import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.MotorBike;

public class BikeOutputDTO {

    public String model;
    public String brand;
    public int ph;

    public BikeOutputDTO(MotorBike motorBike){
        this.model=motorBike.getModel();
        this.brand=motorBike.getBrand();
        this.ph=motorBike.getPh();

    }

}
