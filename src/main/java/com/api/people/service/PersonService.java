package com.api.people.service;

import com.api.people.dto.request.PersonRequestDto;
import com.api.people.dto.response.PersonResponseDto;

import java.util.List;

public interface PersonService {
    PersonResponseDto register(PersonRequestDto requestDto);
    PersonResponseDto findById(Long id);
    List<PersonResponseDto> findAll();
    PersonResponseDto update(Long id, PersonRequestDto requestDto);
    String delete(Long id);
}
