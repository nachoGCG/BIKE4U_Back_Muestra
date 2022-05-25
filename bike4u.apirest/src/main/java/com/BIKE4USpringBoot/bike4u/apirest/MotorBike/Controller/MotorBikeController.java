package com.BIKE4USpringBoot.bike4u.apirest.MotorBike.Controller;

import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.DTO.BikeOutputDTO;
import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.Interface.MotorBikeRepository;
import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.MotorBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/motorbike")
public class MotorBikeController {

    @Autowired
    public MotorBikeRepository motorBikeRepository;

    @GetMapping("getMotorBike/{brand}")
    public List<BikeOutputDTO> getByBrand(@PathVariable("brand") String brand) {
        return motorBikeRepository.findByBrand(brand).stream().
                map(BikeOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("getMotorBikeByModel/{model}")
    public BikeOutputDTO getByModel(@PathVariable("model") String model) {
        return new BikeOutputDTO(motorBikeRepository.findByModel(model));
    }

    @GetMapping("getMotorBikeByPh/{ph}")
    public List<BikeOutputDTO> getByPh(@PathVariable("ph") int ph) {
        return motorBikeRepository.findByPh(ph).stream().
                map(BikeOutputDTO::new).collect(Collectors.toList());
    }

    @PostMapping("create")
    public void create(@RequestBody MotorBike motorBike) {
        motorBikeRepository.save(motorBike);
    }


}
