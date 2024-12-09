package br.com.ldf.domain.service;

import br.com.ldf.application.dto.PersonCreateRequest;
import br.com.ldf.application.dto.PersonResponse;
import br.com.ldf.domain.mapper.PersonMapper;
import br.com.ldf.persistence.entity.Person;
import br.com.ldf.persistence.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonService {

    PersonMapper mapper;
    PersonRepository repository;

    public Person createPerson(PersonCreateRequest request) {
        return repository.save(mapper.toEntity(request));
    }
    
    public PersonResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(RuntimeException::new);
    }
}
