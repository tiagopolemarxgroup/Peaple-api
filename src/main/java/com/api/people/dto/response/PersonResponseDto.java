package com.api.people.dto.response;

import com.api.people.model.Person;
import lombok.Getter;

@Getter
public class PersonResponseDto {
    private Long id;
    private String name;
    private String cpf;
    private Integer age;

    public PersonResponseDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();
    }
}
