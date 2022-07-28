package com.tiagoramirez_portfolio.portfolio.service;

import com.tiagoramirez_portfolio.portfolio.model.Location;

public interface ILocationService {
    public Location getByPersonId(Integer personId);

    public Location addNew(Location location);

    public Location edit(Location location);
}
