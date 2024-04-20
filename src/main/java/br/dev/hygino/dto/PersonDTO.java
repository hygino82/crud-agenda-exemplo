package br.dev.hygino.dto;

import br.dev.hygino.entities.Address;
import br.dev.hygino.entities.Person;

import java.util.List;
import java.util.stream.Collectors;

public record PersonDTO(
        Long id,
        String name,
        String email,
        String phoneNumber,
        List<AddressDTO> addressList
) {
    public PersonDTO(Person entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getAddressList().stream().map(AddressDTO::new).collect(Collectors.toList())
        );
    }
}
