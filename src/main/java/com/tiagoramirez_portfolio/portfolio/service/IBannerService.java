package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Banner;

public interface IBannerService {
    public Banner addNew(Banner banner);

    public Banner getById(Integer id);

    public byte[] compressBytes(byte[] data);

    public byte[] decompressBytes(byte[] data);
}
