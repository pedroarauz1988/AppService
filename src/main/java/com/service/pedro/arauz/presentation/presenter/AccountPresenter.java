package com.service.pedro.arauz.presentation.presenter;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.entity.Movement;
import com.service.pedro.arauz.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountPresenter {

    @Id
    private UUID id;
    @NotNull
    private Integer accountNumber;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @NotNull
    @PositiveOrZero
    private BigDecimal initialAmount;
    @Builder.Default
    private Boolean status = Boolean.TRUE;
    private ClientPresenter clientPresenter;
}
