package com.liargame.accountapi.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CreateMember {
    @NotNull
    @NotEmpty
    private String nickname;

    @NotNull
    @NotEmpty
    private String sex;

    @NotNull
    @Min(0)
    private int age;

    @NotNull
    @NotEmpty
    private String country;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String district;
}
