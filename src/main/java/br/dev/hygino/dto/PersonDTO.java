package br.dev.hygino.dto;

import br.dev.hygino.entities.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String zipCode;
    private String phoneNumber;

    public PersonDTO(Person entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        address = entity.getAddress();
        zipCode = entity.getZipCode();
        phoneNumber = entity.getPhoneNumber();
    }
}
