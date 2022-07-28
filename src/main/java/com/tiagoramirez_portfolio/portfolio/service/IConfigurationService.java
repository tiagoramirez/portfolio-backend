package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Configuration;

public interface IConfigurationService {
    public Configuration getByPersonId(Integer personId);

    public Configuration addNew(Configuration msm);

    public Configuration edit(Configuration msm);
}
