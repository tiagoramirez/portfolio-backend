package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;

public interface IMySocialMediaService {
    public List<MySocialMedia> getAll();

    public void addNew(MySocialMedia msm);
}
