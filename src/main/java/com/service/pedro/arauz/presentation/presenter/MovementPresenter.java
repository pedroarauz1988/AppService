package com.service.pedro.arauz.presentation.presenter;

import com.service.pedro.arauz.entity.Account;
import com.service.pedro.arauz.enums.AccountType;
import com.service.pedro.arauz.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementPresenter {

    @Id
    private UUID id;
    @NotNull
    private Date date;
    @NotNull
    @Enumerated(EnumType.STRING)
    private MovementType movementType;
    private String observation;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private BigDecimal balance;
    @NotNull
    private AccountPresenter accountPresenter;
}
