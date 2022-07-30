package com.aiotouch.emojiquizapp.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @Column(name = "image_path")
    public String imagePath;

    @NotNull
    @Column(name = "option_1")
    public String option1;

    @NotNull
    @Column(name = "option_2")
    public String option2;

    @NotNull
    @Column(name = "option_3")
    public String option3;

    @NotNull
    @Column(name = "answer")
    public String answer;

}
