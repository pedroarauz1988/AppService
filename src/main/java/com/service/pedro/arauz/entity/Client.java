package com.service.pedro.arauz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne(fetch = FetchType.EAGER)
    private Person person;
    @NotNull
    private String password;
    @Builder.Default
    private Boolean status = Boolean.TRUE;
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Account> accounts = new ArrayList<>();


}
