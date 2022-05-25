package com.BIKE4USpringBoot.bike4u.apirest.Announcement;

import com.BIKE4USpringBoot.bike4u.apirest.Announcement.DTO.AnnouncementInputDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "Announcement")
public class Announcement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "ph")
    private int ph;

    @Column(name = "km")
    private int km;

    @Column(name = "isLimited")
    private Boolean isLimited;

    @Column(name = "description")
    private String description;

    @Column(name = "nameUser")
    private String nameUser;

    @Column(name = "price")
    private int price;

    public Announcement(AnnouncementInputDTO announcementInputDTO) {
        this.setTitle(announcementInputDTO.getTitle());
        this.setNameUser(announcementInputDTO.getNameUser());
        this.setDescription(announcementInputDTO.getDescription());
        this.setIsLimited(announcementInputDTO.getIsLimited());
        this.setModel(announcementInputDTO.getModel());
        this.setKm(announcementInputDTO.getKm());
        this.setPrice(announcementInputDTO.getPrice());
    }


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "model", updatable = false, insertable = false)
//    @JsonIgnore
//    private MotorBike motorBike;
}
