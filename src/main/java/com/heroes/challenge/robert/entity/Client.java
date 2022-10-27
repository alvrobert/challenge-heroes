package com.heroes.challenge.robert.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Client {

    @Id
    @Column(unique = true, nullable = false)
    private BigInteger document;

    private String name;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
}
