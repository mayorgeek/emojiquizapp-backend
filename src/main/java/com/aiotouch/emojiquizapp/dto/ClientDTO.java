package com.aiotouch.emojiquizapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClientDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;

}
