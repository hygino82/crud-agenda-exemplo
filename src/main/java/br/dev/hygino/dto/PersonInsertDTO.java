package br.dev.hygino.dto;

public record PersonInsertDTO(
        String firstName,
        String lastName,
        String email,
        String address,
        String zipCode,
        String phoneNumber) {

}
