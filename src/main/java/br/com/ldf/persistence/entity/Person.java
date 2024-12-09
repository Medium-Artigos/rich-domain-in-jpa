package br.com.ldf.persistence.entity;

import br.com.ldf.domain.model.Cpf;
import br.com.ldf.domain.model.Email;
import br.com.ldf.domain.model.Phone;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Cpf cpf;

    @Column(nullable = false)
    Email email;

    @Column(nullable = false)
    Phone phone;
}
