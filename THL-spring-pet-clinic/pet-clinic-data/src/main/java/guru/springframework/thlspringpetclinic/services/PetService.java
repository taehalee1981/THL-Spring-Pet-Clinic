package guru.springframework.thlspringpetclinic.services;

import guru.springframework.thlspringpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
