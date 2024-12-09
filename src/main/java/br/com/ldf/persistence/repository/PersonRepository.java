package br.com.ldf.persistence.repository;

import br.com.ldf.persistence.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
