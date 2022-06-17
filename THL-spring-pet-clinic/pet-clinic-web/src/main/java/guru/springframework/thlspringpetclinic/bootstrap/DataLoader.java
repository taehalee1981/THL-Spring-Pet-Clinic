package guru.springframework.thlspringpetclinic.bootstrap;

import guru.springframework.thlspringpetclinic.model.Owner;
import guru.springframework.thlspringpetclinic.model.PetType;
import guru.springframework.thlspringpetclinic.model.Vet;
import guru.springframework.thlspringpetclinic.services.OwnerService;
import guru.springframework.thlspringpetclinic.services.PetTypeService;
import guru.springframework.thlspringpetclinic.services.VetService;
import guru.springframework.thlspringpetclinic.services.map.OwnerServiceMap;
import guru.springframework.thlspringpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //vai ser autowired ja que os services foram modificados para serem @Service
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
