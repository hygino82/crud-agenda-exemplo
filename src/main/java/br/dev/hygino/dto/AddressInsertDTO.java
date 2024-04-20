package br.dev.hygino.dto;

public record AddressInsertDTO(
        String city,
        String streetName,
        Integer streetNumber,
        String zipCode,
        Long personId
) {
}
