package guru.springframework.thlspringpetclinic.services.springdatajpa;

import guru.springframework.thlspringpetclinic.model.Owner;
import guru.springframework.thlspringpetclinic.model.Pet;
import guru.springframework.thlspringpetclinic.model.PetType;
import guru.springframework.thlspringpetclinic.repositories.PetTypeRepository;
import guru.springframework.thlspringpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petts = new HashSet<>();
        petTypeRepository.findAll().forEach(petts::add);
        return petts;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}