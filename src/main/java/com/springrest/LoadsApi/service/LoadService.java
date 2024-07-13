package com.springrest.LoadsApi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.LoadsApi.entity.Load;
import com.springrest.LoadsApi.repository.LoadRepository;

@Service
public class LoadService {
    @Autowired
    private LoadRepository loadRepository;

    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    public Load updateLoad(UUID loadId, Load load) {
        load.setId(loadId);
        return loadRepository.save(load);
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
