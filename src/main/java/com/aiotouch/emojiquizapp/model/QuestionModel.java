package com.aiotouch.emojiquizapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionModel {

    @NotNull
    private String imagePath;

    @NotNull
    private String option1;

    @NotNull
    private String option2;

    @NotNull
    private String option3;

}
