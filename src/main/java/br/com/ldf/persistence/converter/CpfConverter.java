package br.com.ldf.persistence.converter;

import br.com.ldf.domain.model.Cpf;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.util.Objects.nonNull;

@Converter(autoApply = true)
public class CpfConverter implements AttributeConverter<Cpf, String> {
    @Override
    public String convertToDatabaseColumn(Cpf cpf) {
        return nonNull(cpf) ? cpf.getValue() : null;
    }

    @Override
    public Cpf convertToEntityAttribute(String value) {
        return nonNull(value) ? new Cpf(value) : null;
    }
}
