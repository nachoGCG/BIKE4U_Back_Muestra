package com.BIKE4USpringBoot.bike4u.apirest.MotorBike;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "MotorBike")
public class MotorBike implements Serializable {

    @Id
    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "ph")
    private int ph;

}
