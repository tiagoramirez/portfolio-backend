package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;

public interface IMySocialMediaService {
    public List<MySocialMedia> getByPersonId(Integer personId);

    public MySocialMedia getById(Integer id);

    public MySocialMedia addNew(MySocialMedia msm);

    public MySocialMedia edit(MySocialMedia msm);

    public void delete(Integer id);
}