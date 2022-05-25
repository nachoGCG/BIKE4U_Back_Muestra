package com.BIKE4USpringBoot.bike4u.apirest.Announcement.DTO;

import com.BIKE4USpringBoot.bike4u.apirest.Announcement.Announcement;

public class AnnouncementOutputDTO {
    public int id;
    public String title;
    public String bikeBrand;
    public String bikeModel;
    public int bikePh;
    public int km;
    public Boolean isLimited;
    public String description;
    public String nameUser;
    public int price;

    public AnnouncementOutputDTO(Announcement announcement){
        if (announcement.getTitle()!=null) this.title=announcement.getTitle();
        if (announcement.getBrand()!=null)this.bikeBrand=announcement.getBrand();
        if (announcement.getModel()!=null)this.bikeModel=announcement.getModel();
        if (announcement.getDescription()!=null)this.description=announcement.getDescription();
        if (announcement.getNameUser()!=null)this.nameUser=announcement.getNameUser();
        this.price=announcement.getPrice();
        this.bikePh=announcement.getPh();
        this.km=announcement.getKm();
        this.isLimited=announcement.getIsLimited();
        this.id=announcement.getId();

    }

}
