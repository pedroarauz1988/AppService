package com.service.pedro.arauz.entity;

import com.service.pedro.arauz.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Client client;
}
