package com.adk.user.service.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankushk
 */

@Entity
@Data
@Getter
@Setter
@Table(name = "Micro_User")
public class User {
    @Id
    @Column(name="ID")
    private String userId;


    @Column(name="Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name="About")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
