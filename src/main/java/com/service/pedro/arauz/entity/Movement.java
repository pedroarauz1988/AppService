package com.service.pedro.arauz.entity;

import com.service.pedro.arauz.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
