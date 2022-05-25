package com.BIKE4USpringBoot.bike4u.apirest.Announcement.Interface;

import com.BIKE4USpringBoot.bike4u.apirest.Announcement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,String> {
    Announcement findById(int id);
    List<Announcement> findByModel(String model);
    List<Announcement> findByBrand(String brand);
    List<Announcement> findByPh(int ph);
    List<Announcement> findByPrice(int price);
    List<Announcement> findByIsLimited(Boolean isLimited);
    List<Announcement> findByKm(int km);
    void deleteAnnouncementByNameUser(String nameUser);
}
