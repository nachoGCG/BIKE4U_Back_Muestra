package com.BIKE4USpringBoot.bike4u.apirest.User;

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
@Table(name = "Users")
public class User implements Serializable {


    @Id
    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "title")
//    private List<Announcement> announcements;

}
