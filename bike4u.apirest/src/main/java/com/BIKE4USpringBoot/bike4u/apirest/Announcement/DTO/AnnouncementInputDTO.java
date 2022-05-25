package com.BIKE4USpringBoot.bike4u.apirest.Announcement.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementInputDTO {
    private String title;
    private String model;
    private String nameUser;
    private int km;
    private String description;
    private Boolean isLimited;
    private int price;

}
