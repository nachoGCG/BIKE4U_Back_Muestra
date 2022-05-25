package com.BIKE4USpringBoot.bike4u.apirest.MotorBike.Interface;

import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.MotorBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorBikeRepository extends JpaRepository<MotorBike,String> {

    List<MotorBike> findByBrand(String brand);
    MotorBike findByModel(String model);
    List<MotorBike> findByPh(int ph);

}
