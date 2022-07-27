package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.LocationRepository;
import com.tiagoramirez_portfolio.portfolio.model.Location;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location getByPersonId(Integer personId) {
        return locationRepository.findByPersonIdLike(personId);
    }

    @Override
    public Location addNew(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location edit(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

}
