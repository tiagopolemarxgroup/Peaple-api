package com.api.people.service;

import com.api.people.dto.request.PersonRequestDto;
import com.api.people.dto.response.PersonResponseDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PersonServiceImpl implements PersonService{
    @Override
    public PersonResponseDto findById(Long id) {
        return null;
    }

    @Override
    public List<PersonResponseDto> findAll() {
        return null;
    }

    @Override
    public PersonResponseDto register(PersonRequestDto requestDto) {
        return null;
    }

    @Override
    public PersonResponseDto update(PersonRequestDto requestDto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
