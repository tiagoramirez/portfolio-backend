package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.PersonRepository;
import com.tiagoramirez_portfolio.portfolio.model.Person;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void addNew(Person person) {
        personRepository.save(person);
    }
}
