package guru.springframework.thlspringpetclinic.repositories;

import guru.springframework.thlspringpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
