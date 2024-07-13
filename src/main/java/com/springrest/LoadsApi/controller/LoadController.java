package com.springrest.LoadsApi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.LoadsApi.entity.Load;
import com.springrest.LoadsApi.service.LoadService;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public String addLoad(@RequestBody Load load) {
        loadService.addLoad(load);
        return "Load details added successfully";
    }

    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam UUID shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public Load getLoadById(@PathVariable UUID loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/{loadId}")
    public Load updateLoad(@PathVariable UUID loadId, @RequestBody Load load) {
        return loadService.updateLoad(loadId, load);
    }

    @DeleteMapping("/{loadId}")
    public String deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return "Load deleted successfully";
    }
}
