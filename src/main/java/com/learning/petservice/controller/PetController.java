package com.learning.petservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.learning.petservice.api.PetServiceApi;
import com.learning.petservice.model.Pet;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController implements PetServiceApi {

    @Override
    public ResponseEntity<List<Pet>> getAllCats() {
        List<Pet> cats = new ArrayList<>();

        Pet cat0 = new Pet();
        cat0.setName("Frajola");
        cat0.setPetType(Pet.PetTypeEnum.CAT);
        cats.add(cat0);

        Pet cat1 = new Pet();
        cat1.setName("Manda-Chuva");
        cat1.setPetType(Pet.PetTypeEnum.CAT);
        cats.add(cat1);

        Pet cat2 = new Pet();
        cat2.setName("Garfield");
        cat2.setPetType(Pet.PetTypeEnum.CAT);

        cats.add(cat2);

        return new ResponseEntity<>(cats, HttpStatus.OK);
    }
}
