package com.learning.dasboot.controller;

import com.learning.dasboot.model.Shipwreck;
import com.learning.dasboot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Optional<Shipwreck> get(@PathVariable Long id) {
        return shipwreckRepository.findById(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck put(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        Optional<Shipwreck> shipwreck1 = shipwreckRepository.findById(id);
        BeanUtils.copyProperties(shipwreck, shipwreck1.get());
        return shipwreckRepository.saveAndFlush(shipwreck1.get());
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public void post(@RequestBody Shipwreck shipwreck) {
        shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        shipwreckRepository.deleteById(id);
    }
}
