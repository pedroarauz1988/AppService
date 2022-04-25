package com.service.pedro.arauz.presentation.presenter;

import com.service.pedro.arauz.entity.Account;
import com.service.pedro.arauz.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientPresenter {

    private UUID id;
    @NotNull
    private PersonPresenter personPresenter;
    @NotNull
    private String password;
    @Builder.Default
    private Boolean status = Boolean.TRUE;
}
