package br.com.ldf.application.dto;

import br.com.ldf.domain.model.Cpf;
import br.com.ldf.domain.model.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PersonCreateRequest(
        @NotBlank
        @Pattern(regexp = Cpf.VALID_CPF)
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = Phone.REGEX_VALID_PHONE)
        String phone
) {
}
