package de.braincooler.persongenerator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private AddressEntity address;
}