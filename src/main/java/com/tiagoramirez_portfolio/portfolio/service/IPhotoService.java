package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Photo;

public interface IPhotoService {
    public Photo addNew(Photo photo);

    public Photo getById(Integer id);

    public byte[] compressBytes(byte[] data);

    public byte[] decompressBytes(byte[] data);
}
