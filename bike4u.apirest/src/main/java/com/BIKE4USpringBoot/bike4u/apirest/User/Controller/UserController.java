package com.BIKE4USpringBoot.bike4u.apirest.User.Controller;

import com.BIKE4USpringBoot.bike4u.apirest.Mail.EmailSender;
import com.BIKE4USpringBoot.bike4u.apirest.Mail.SendEmailThread;
import com.BIKE4USpringBoot.bike4u.apirest.User.DTO.UserOutputDTO;
import com.BIKE4USpringBoot.bike4u.apirest.User.Interface.UserRespository;
import com.BIKE4USpringBoot.bike4u.apirest.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRespository userRespository;

    @Autowired
    public EmailSender emailSender;


    @GetMapping("/getUser/{userName}")
    public UserOutputDTO getUserByUserName(@PathVariable("userName") String userName) throws Exception {

        User user = userRespository.findByUserName(userName);

        if (user==null){
            return null;
        }
        return new UserOutputDTO(user);


    }

    @PostMapping("/create")
    public UserOutputDTO createUser(@RequestBody User user) throws Exception {
        if (getUserByUserName(user.getUserName()) != null) {
            throw new Exception("Ya existe un usiario con es nombre");
        }
        Runnable r = new SendEmailThread(user.getUserName(), user.getEmail(),emailSender);
        new Thread(r).start();


        return new UserOutputDTO(userRespository.save(user));
    }

    @GetMapping("/getAll")
    public List<UserOutputDTO> getAll() throws Exception {
        return userRespository.findAll().stream().map(UserOutputDTO::new).collect(Collectors.toList());
    }


}
