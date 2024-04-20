package br.dev.hygino.dto;

import br.dev.hygino.entities.Address;

public record AddressDTO(
        Long id,
        String city,
        String streetName,
        Integer streetNumber,
        String zipCode,
        Long personId,
        String personName

) {
    public AddressDTO(Address entity) {
        this(entity.getId(), entity.getCity(), entity.getStreetName(), entity.getStreetNumber(), entity.getZipCode(), entity.getPerson().getId(), entity.getPerson().getName());
    }
}
