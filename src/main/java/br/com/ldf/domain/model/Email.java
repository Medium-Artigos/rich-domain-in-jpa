package br.com.ldf.domain.model;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Email {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private final String value;

    public Email(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.value = value.trim();
    }

    @Override
    public String toString() {
        return value;
    }
}
