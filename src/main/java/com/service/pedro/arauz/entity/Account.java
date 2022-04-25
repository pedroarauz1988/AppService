package com.service.pedro.arauz.entity;

import com.service.pedro.arauz.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Column(unique = true)
    private Integer accountNumber;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @NotNull
    @PositiveOrZero
    private BigDecimal initialAmount;
    @Builder.Default
    private Boolean status = Boolean.TRUE;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Movement> movements = new ArrayList<>();

}
