package guru.springframework.sfgpetclinic1.bootstrap;

import guru.springframework.sfgpetclinic1.model.Owner;
import guru.springframework.sfgpetclinic1.model.PetType;
import guru.springframework.sfgpetclinic1.model.Vet;
import guru.springframework.sfgpetclinic1.model.services.OwnerService;
import guru.springframework.sfgpetclinic1.model.services.PetTypeService;
import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService pettypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService pettypeService) {
        this.pettypeService = pettypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType pettype = new PetType();
        pettype.setName("dog");
        PetType savedpettype = pettypeService.save(pettype);

        PetType pettype1 = new PetType();
        pettype.setName("cat");
        PetType savedpettype1 = pettypeService.save(pettype1);

        Owner owner = new Owner();

        owner.setFirstName("gafoor");
        owner.setLastName("Ikka");
        ownerService.save(owner);

        Owner owner1 = new Owner();

        owner1.setFirstName("cid");
        owner1.setLastName("vijayan");
        ownerService.save(owner1);

        System.out.println("Loaded Owners");

        Vet vet = new Vet();

        vet.setFirstName("doctor");
        vet.setLastName("pashupathi");
        vetService.save(vet);

        Vet vet1 = new Vet();

        vet1.setFirstName("doctor");
        vet1.setLastName("pashupathi1");
        vetService.save(vet1);

        System.out.println("Loaded Vets");


    }
}
