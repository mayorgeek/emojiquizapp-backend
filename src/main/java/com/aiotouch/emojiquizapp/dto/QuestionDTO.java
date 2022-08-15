package com.aiotouch.emojiquizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionDTO {

    @NotNull
    private String imagePath;

    @NotNull
    private String option1;

    @NotNull
    private String option2;

    @NotNull
    private String option3;

    @NotNull
    private String answer;

}
