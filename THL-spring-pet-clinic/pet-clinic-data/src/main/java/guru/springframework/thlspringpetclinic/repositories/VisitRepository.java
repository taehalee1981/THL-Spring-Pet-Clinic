package guru.springframework.thlspringpetclinic.repositories;

import guru.springframework.thlspringpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
