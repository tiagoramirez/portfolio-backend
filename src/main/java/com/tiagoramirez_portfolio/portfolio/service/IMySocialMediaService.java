package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;

public interface IMySocialMediaService {
    public List<MySocialMedia> getByPersonId(Integer personId);

    public void addNew(MySocialMedia msm);
}
