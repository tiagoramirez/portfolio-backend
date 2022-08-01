package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.ConfigurationRepository;
import com.tiagoramirez_portfolio.portfolio.model.Configuration;

@Service
public class ConfigurationService implements IConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public Configuration getByProfileId(Integer profileId) {
        return configurationRepository.findByProfileIdLike(profileId);
    }

    @Override
    public Configuration addNew(Configuration msm) {
        return configurationRepository.save(msm);
    }

    @Override
    public Configuration edit(Configuration msm) {
        return configurationRepository.save(msm);
    }
}
