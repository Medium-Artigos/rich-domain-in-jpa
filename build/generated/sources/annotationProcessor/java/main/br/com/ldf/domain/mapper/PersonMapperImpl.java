package br.com.ldf.domain.mapper;

import br.com.ldf.application.dto.PersonCreateRequest;
import br.com.ldf.application.dto.PersonResponse;
import br.com.ldf.domain.model.Cpf;
import br.com.ldf.domain.model.Email;
import br.com.ldf.domain.model.Phone;
import br.com.ldf.persistence.entity.Person;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T14:30:01-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toEntity(PersonCreateRequest person) {
        if ( person == null ) {
            return null;
        }

        Person person1 = new Person();

        person1.setCpf( personCreateRequestToCpf( person ) );
        person1.setEmail( personCreateRequestToEmail( person ) );
        person1.setPhone( personCreateRequestToPhone( person ) );

        return person1;
    }

    @Override
    public PersonResponse toResponse(Person person) {
        if ( person == null ) {
            return null;
        }

        String cpf = null;
        String email = null;
        String phone = null;
        Long id = null;

        cpf = personCpfFormatted( person );
        email = personEmailValue( person );
        phone = personPhoneFormatted( person );
        id = person.getId();

        PersonResponse personResponse = new PersonResponse( id, cpf, email, phone );

        return personResponse;
    }

    protected Cpf personCreateRequestToCpf(PersonCreateRequest personCreateRequest) {
        if ( personCreateRequest == null ) {
            return null;
        }

        String value = null;

        value = personCreateRequest.cpf();

        Cpf cpf = new Cpf( value );

        return cpf;
    }

    protected Email personCreateRequestToEmail(PersonCreateRequest personCreateRequest) {
        if ( personCreateRequest == null ) {
            return null;
        }

        String value = null;

        value = personCreateRequest.email();

        Email email = new Email( value );

        return email;
    }

    protected Phone personCreateRequestToPhone(PersonCreateRequest personCreateRequest) {
        if ( personCreateRequest == null ) {
            return null;
        }

        String value = null;

        value = personCreateRequest.phone();

        Phone phone = new Phone( value );

        return phone;
    }

    private String personCpfFormatted(Person person) {
        if ( person == null ) {
            return null;
        }
        Cpf cpf = person.getCpf();
        if ( cpf == null ) {
            return null;
        }
        String formatted = cpf.getFormatted();
        if ( formatted == null ) {
            return null;
        }
        return formatted;
    }

    private String personEmailValue(Person person) {
        if ( person == null ) {
            return null;
        }
        Email email = person.getEmail();
        if ( email == null ) {
            return null;
        }
        String value = email.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String personPhoneFormatted(Person person) {
        if ( person == null ) {
            return null;
        }
        Phone phone = person.getPhone();
        if ( phone == null ) {
            return null;
        }
        String formatted = phone.getFormatted();
        if ( formatted == null ) {
            return null;
        }
        return formatted;
    }
}
