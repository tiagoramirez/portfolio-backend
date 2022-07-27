package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Person;

public interface IPersonService {
    public Person getById(Integer id);

    public Person addNew(Person person);

    public Person edit(Person person);

    public void delete(Integer id);
}
