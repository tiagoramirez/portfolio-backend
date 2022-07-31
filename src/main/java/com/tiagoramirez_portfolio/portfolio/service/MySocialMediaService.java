package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.MySocialMediaRepository;
import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;

@Service
public class MySocialMediaService implements IMySocialMediaService {

    @Autowired
    private MySocialMediaRepository mySocialMediaRepository;

    @Override
    public List<MySocialMedia> getByPersonId(Integer personId) {
        return mySocialMediaRepository.findByPersonIdLike(personId);
    }

    @Override
    public MySocialMedia getById(Integer id) {
        return mySocialMediaRepository.findById(id).orElse(null);
    }

    @Override
    public MySocialMedia addNew(MySocialMedia msm) {
        return mySocialMediaRepository.save(msm);
    }

    @Override
    public MySocialMedia edit(MySocialMedia msm) {
        return mySocialMediaRepository.save(msm);
    }

    @Override
    public void delete(Integer id) {
        mySocialMediaRepository.deleteById(id);
    }

}
