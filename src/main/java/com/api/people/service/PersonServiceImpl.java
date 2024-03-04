package com.api.people.service;

import com.api.people.dto.request.PersonRequestDto;
import com.api.people.dto.response.PersonResponseDto;
import com.api.people.model.Person;
import com.api.people.repository.PersonRepository;
import com.api.people.util.PersonMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper;
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonResponseDto register(PersonRequestDto requestDto) {
        Person person = personMapper.toPerson(requestDto);
        return personMapper.toPersonResponseDto(personRepository.save(person));
    }

    @Override
    public PersonResponseDto findById(Long id) {
        Person person = this.getPerson(id);
        return personMapper.toPersonResponseDto(person);
    }

    @Override
    public List<PersonResponseDto> findAll() {
        List<Person> personList = personRepository.findAll();
        return personMapper.toPeapleDto(personList);
    }

    @Override
    public PersonResponseDto update(Long id, PersonRequestDto requestDto) {
        Person person = this.getPerson(id);
        personMapper.updatePersonDate(person, requestDto);
        person = personRepository.save(person);
        return personMapper.toPersonResponseDto(person);
    }

    @Override
    public String delete(Long id) {
        personRepository.findById(id);
        return "person id " + id + "deleted";
    }

    private Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
