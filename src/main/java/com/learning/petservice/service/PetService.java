package com.learning.petservice.service;

import com.learning.petservice.model.Pet;
import com.learning.petservice.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learning.petservice.model.exception.CatExceptions.catNotFoundException;
import static com.learning.petservice.model.exception.CatExceptions.notCatException;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private MessageSource messageSource;

    public List<Pet> getAllCats() {
        return this.petRepository.findByPetType(Pet.PetTypeEnum.CAT);
    }

    public Pet createCat(Pet cat) {
        if (cat.getPetType() != Pet.PetTypeEnum.CAT) {
            throw notCatException(this.messageSource);
        }
        cat.setId(null);
        return this.petRepository.save(cat);
    }

    public Pet findCat(String id) {
        return this.petRepository.findById(id).orElseThrow(() -> catNotFoundException(this.messageSource));
    }

    public void updateCat(String id, Pet newData) {
        var cat = this.petRepository.findById(id).orElseThrow(() -> catNotFoundException(this.messageSource));

        cat.setName(newData.getName());
        cat.setImgUrl(newData.getImgUrl());
        this.petRepository.save(cat);
    }

    public void deleteCat(String id) {
        var pet = this.petRepository.findById(id).orElseThrow(() -> catNotFoundException(this.messageSource));

        if (pet.getPetType() != Pet.PetTypeEnum.CAT) {
            throw catNotFoundException(this.messageSource);
        }

        this.petRepository.deleteById(id);
    }

}
