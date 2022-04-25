package com.service.pedro.arauz.presentation.presenter;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonPresenter {

    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Positive
    private Integer age;
    @NotNull
    private String identification;
    @NotNull
    private String address;
    @NotNull
    private String phone;
}
