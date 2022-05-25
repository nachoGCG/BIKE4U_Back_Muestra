package com.BIKE4USpringBoot.bike4u.apirest.Announcement.Controller;

import com.BIKE4USpringBoot.bike4u.apirest.Announcement.Announcement;
import com.BIKE4USpringBoot.bike4u.apirest.Announcement.DTO.AnnouncementInputDTO;
import com.BIKE4USpringBoot.bike4u.apirest.Announcement.DTO.AnnouncementOutputDTO;
import com.BIKE4USpringBoot.bike4u.apirest.Announcement.Interface.AnnouncementRepository;
import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.Interface.MotorBikeRepository;
import com.BIKE4USpringBoot.bike4u.apirest.MotorBike.MotorBike;
import com.BIKE4USpringBoot.bike4u.apirest.User.Interface.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
@CrossOrigin
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    public MotorBikeRepository motorBikeRepository;
    @Autowired
    public AnnouncementRepository announcementRepository;
    @Autowired
    public UserRespository userRespository;

    @GetMapping("/getAllAnnouncement")
    public List<AnnouncementOutputDTO> getAllAnnouncement() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getAnnouncementById/{id}")
    public AnnouncementOutputDTO getAnnouncementById(@PathVariable("id") int id) {
        return new AnnouncementOutputDTO(announcementRepository.findById(id));
    }

    @GetMapping("/getAnnouncementByModel/{model}")
    public List<AnnouncementOutputDTO> getAnnouncementByModel(@PathVariable("model") String model) {
        List<Announcement> announcements = announcementRepository.findByModel(model);
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getAnnouncementByBrand/{brand}")
    public List<AnnouncementOutputDTO> getAnnouncementByBrand(@PathVariable("brand") String brand) {
        List<Announcement> announcements = announcementRepository.findByBrand(brand);
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getAnnouncementByPh/{ph}")
    public List<AnnouncementOutputDTO> getAnnouncementByPh(@PathVariable("ph") int ph) {
        List<Announcement> announcements = announcementRepository.findByPh(ph);
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getAnnouncementByPrice/{price}")
    public List<AnnouncementOutputDTO> getAnnouncementByPrice(@PathVariable("price") int price) {
        List<Announcement> announcements = announcementRepository.findByPrice(price);
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getAnnouncementByIsLimited/{isLimited}")
    public List<AnnouncementOutputDTO> getAnnouncementByIsLimited(@PathVariable("isLimited") Boolean isLimited) {
        List<Announcement> announcements = announcementRepository.findByIsLimited(isLimited);
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getAnnouncementByKm/{km}")
    public List<AnnouncementOutputDTO> getAnnouncementByKm(@PathVariable("km") int km) {
        List<Announcement> announcements = announcementRepository.findByKm(km);
        return announcements.stream().map(AnnouncementOutputDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping("deleteAnnouncement/{nameUser}")
    public boolean deleteAnnouncement(@PathVariable("nameUser")String nameUser) {
        announcementRepository.deleteAnnouncementByNameUser(nameUser);
        return true;
    }

    @PostMapping("/create")
    public AnnouncementOutputDTO createAnnouncement(@RequestBody AnnouncementInputDTO announcementInputDTO) throws Exception {
        Announcement announcement = new Announcement(announcementInputDTO);
        MotorBike motorBike = motorBikeRepository.findByModel(announcement.getModel());
        announcement.setPh(motorBike.getPh());
        announcement.setBrand(motorBike.getBrand());
        announcement.setModel(motorBike.getModel());

        if (userRespository.findByUserName(announcement.getNameUser()) == null) {
            throw new Exception("No existe ningun usuario con este nombre: " + announcement.getNameUser());
        }

        return new AnnouncementOutputDTO(announcementRepository.save(announcement));

    }

}
