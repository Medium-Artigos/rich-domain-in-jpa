package br.com.ldf.application.dto;

public record PersonResponse(
        Long id,
        String cpf,
        String email,
        String phone
) {
}
