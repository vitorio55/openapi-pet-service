package com.learning.petservice.repository;

import com.learning.petservice.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetRepository extends MongoRepository<Pet, String> {
    List<Pet> findByPetType(Pet.PetTypeEnum petType);
}
