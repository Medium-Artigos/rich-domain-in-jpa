package br.com.ldf.persistence.converter;

import br.com.ldf.domain.model.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.util.Objects.nonNull;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email email) {
        return nonNull(email) ? email.getValue() : null;
    }

    @Override
    public Email convertToEntityAttribute(String value) {
        return nonNull(value) ? new Email(value) : null;
    }
}
