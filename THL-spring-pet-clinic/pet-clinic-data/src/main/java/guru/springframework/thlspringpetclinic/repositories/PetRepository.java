package guru.springframework.thlspringpetclinic.repositories;

import guru.springframework.thlspringpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
