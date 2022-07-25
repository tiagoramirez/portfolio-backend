package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import com.tiagoramirez_portfolio.portfolio.model.Person;

public interface IPersonService {
    public List<Person> getAll();

    public void addNew(Person person);
}
