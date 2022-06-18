package guru.springframework.thlspringpetclinic.repositories;

import guru.springframework.thlspringpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
