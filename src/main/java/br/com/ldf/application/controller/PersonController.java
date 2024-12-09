package br.com.ldf.application.controller;

import br.com.ldf.application.dto.PersonCreateRequest;
import br.com.ldf.application.dto.PersonResponse;
import br.com.ldf.domain.service.PersonService;
import br.com.ldf.persistence.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated PersonCreateRequest request) {
        var person = personService.createPerson(request);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(person.getId()).toUri()
        ).build();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }
}
