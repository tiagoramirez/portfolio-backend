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
    public List<MySocialMedia> getAll() {
        return mySocialMediaRepository.findAll();
    }

    @Override
    public void addNew(MySocialMedia msm) {
        mySocialMediaRepository.save(msm);
    }

}
