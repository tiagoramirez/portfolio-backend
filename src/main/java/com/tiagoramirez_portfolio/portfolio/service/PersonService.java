package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.PersonRepository;
import com.tiagoramirez_portfolio.portfolio.model.Person;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person addNew(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person edit(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

}
