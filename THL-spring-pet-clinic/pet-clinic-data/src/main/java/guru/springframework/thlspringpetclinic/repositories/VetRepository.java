package guru.springframework.thlspringpetclinic.repositories;

import guru.springframework.thlspringpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
