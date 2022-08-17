package com.aiotouch.emojiquizapp.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
public class ClientDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(
            name = "username",
            nullable = false
    )
    private String username;


    @Column(
            name = "password",
            nullable = false
    )
    private String password;

}