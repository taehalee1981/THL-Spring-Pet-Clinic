package guru.springframework.thlspringpetclinic.services;

import guru.springframework.thlspringpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
