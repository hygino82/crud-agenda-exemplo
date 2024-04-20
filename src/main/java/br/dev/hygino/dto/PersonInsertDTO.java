package br.dev.hygino.dto;

public record PersonInsertDTO(
        String name,
        String email,
        String address,
        String zipCode,
        String phoneNumber) {

}
