package guru.springframework.thlspringpetclinic.services;

import guru.springframework.thlspringpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
