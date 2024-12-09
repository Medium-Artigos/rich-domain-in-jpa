package br.com.ldf.persistence.converter;

import br.com.ldf.domain.model.Phone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.util.Objects.nonNull;

@Converter(autoApply = true)
public class PhoneConverter implements AttributeConverter<Phone, String> {
    @Override
    public String convertToDatabaseColumn(Phone phone) {
        return nonNull(phone) ? phone.getValue() : null;
    }

    @Override
    public Phone convertToEntityAttribute(String value) {
        return nonNull(value) ? new Phone(value) : null;
    }
}
