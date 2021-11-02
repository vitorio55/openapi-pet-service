package com.learning.petservice.controller;

import com.learning.petservice.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learning.petservice.api.PetServiceApi;
import com.learning.petservice.model.Pet;

import java.util.List;

@RestController
@Slf4j
public class PetController implements PetServiceApi {

    @Autowired
    private PetService petService;

    @Override
    public ResponseEntity<List<Pet>> getAllCats() {
        log.info("Received request to retrieve all cats");
        return new ResponseEntity<>(this.petService.getAllCats(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> createCat(@RequestBody Pet cat) {
        log.info("Received request to create cat");
        this.petService.createCat(cat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateCat(@PathVariable String id,
                                          @RequestBody Pet pet) {
        log.info("Received request to update cat");
        this.petService.updateCat(id, pet);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Pet> findCat(@PathVariable String id) {
        log.info("Received request to retrieve cat");
        return new ResponseEntity<>(this.petService.findCat(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteCat(@PathVariable String id) {
        log.info("Received request to delete cat");
        this.petService.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
