package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Configuration;
import com.tiagoramirez_portfolio.portfolio.repository.ConfigurationRepository;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    public Configuration getByProfileId(Integer profileId) {
        return configurationRepository.findByProfileIdLike(profileId);
    }

    public Configuration addNew(Configuration msm) {
        return configurationRepository.save(msm);
    }

    public Configuration edit(Configuration msm) {
        return configurationRepository.save(msm);
    }
}
