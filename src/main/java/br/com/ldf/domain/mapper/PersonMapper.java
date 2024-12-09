package br.com.ldf.domain.mapper;

import br.com.ldf.application.dto.PersonCreateRequest;
import br.com.ldf.application.dto.PersonResponse;
import br.com.ldf.persistence.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf.value", source = "cpf")
    @Mapping(target = "email.value", source = "email")
    @Mapping(target = "phone.value", source = "phone")
    Person toEntity(PersonCreateRequest person);

    @Mapping(target = "cpf", source = "cpf.formatted")
    @Mapping(target = "email", source = "email.value")
    @Mapping(target = "phone", source = "phone.formatted")
    PersonResponse toResponse(Person person);
}
