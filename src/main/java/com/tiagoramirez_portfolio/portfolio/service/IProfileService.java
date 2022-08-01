package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Profile;

public interface IProfileService {
    public Profile getById(Integer id);

    public Profile addNew(Profile profile);

    public Profile edit(Profile profile);

    public void delete(Integer id);
}
