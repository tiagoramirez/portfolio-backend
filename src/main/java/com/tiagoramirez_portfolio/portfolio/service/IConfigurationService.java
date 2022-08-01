package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Configuration;

public interface IConfigurationService {
    public Configuration getByProfileId(Integer profileId);

    public Configuration addNew(Configuration msm);

    public Configuration edit(Configuration msm);
}
