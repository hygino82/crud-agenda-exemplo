package br.dev.hygino.entities;

import br.dev.hygino.dto.AddressInsertDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_address")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String city;
    private String streetName;
    private Integer streetNumber;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @NotNull
    private Person person;

    public Address(AddressInsertDTO dto) {
        city = dto.city();
        streetName = dto.streetName();
        streetNumber = dto.streetNumber();
        zipCode = dto.zipCode();
    }
}
