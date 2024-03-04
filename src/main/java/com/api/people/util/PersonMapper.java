package com.api.people.util;

import com.api.people.dto.request.PersonRequestDto;
import com.api.people.dto.response.PersonResponseDto;
import com.api.people.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonMapper {

    public Person toPerson(PersonRequestDto requestDto){
        return Person.builder()
                .name(requestDto.getName())
                .cpf(requestDto.getCpf())
                .age(requestDto.getAge())
                .build();
    }

    public PersonResponseDto toPersonResponseDto(Person person){
        return new PersonResponseDto(person);
    }

    public List<PersonResponseDto> toPeapleDto(List<Person> personList){
        return personList.stream().map(PersonResponseDto::new).toList();
    }

    public void updatePersonDate(Person person, PersonRequestDto personRequestDto){
        person.setName(personRequestDto.getName());
        person.setCpf(personRequestDto.getCpf());
        person.setAge(personRequestDto.getAge());
    }
}
