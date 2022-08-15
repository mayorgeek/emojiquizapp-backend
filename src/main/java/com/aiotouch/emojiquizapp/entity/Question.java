package com.aiotouch.emojiquizapp.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;


    @Column(
            name = "image_path",
            nullable = false
    )
    public String imagePath;


    @Column(
            name = "option_1",
            nullable = false
    )
    public String option1;


    @Column(
            name = "option_2",
            nullable = false
    )
    public String option2;


    @Column(
            name = "option_3",
            nullable = false
    )
    public String option3;


    @Column(
            name = "answer",
            nullable = false
    )
    public String answer;

}
