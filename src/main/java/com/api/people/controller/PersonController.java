package com.api.people.controller;

import com.api.people.dto.request.PersonRequestDto;
import com.api.people.dto.response.PersonResponseDto;
import com.api.people.service.PersonService;
import com.api.people.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @PostMapping
    public ResponseEntity<PersonResponseDto> register(@RequestBody PersonRequestDto requestDto, UriComponentsBuilder builder) {
        PersonResponseDto response = personService.register(requestDto);
        URI uri = builder.path("/peaple/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDto> findByid(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDto> update(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return ResponseEntity.ok(personService.update(id, requestDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.notFound().build();
    }


}
