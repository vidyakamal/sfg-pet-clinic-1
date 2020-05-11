package guru.springframework.sfgpetclinic1.bootstrap;

import guru.springframework.sfgpetclinic1.model.Owner;
import guru.springframework.sfgpetclinic1.model.Vet;
import guru.springframework.sfgpetclinic1.model.services.OwnerService;
import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerServiceMap;
    private final VetService vetServiceMap;

    public DataLoader(OwnerService ownerServiceMap, VetService vetServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();

        owner.setFirstName("gafoor");
        owner.setLastName("Ikka");
        ownerServiceMap.save(owner);

        Owner owner1 = new Owner();

        owner1.setFirstName("cid");
        owner1.setLastName("vijayan");
        ownerServiceMap.save(owner1);

        System.out.println("Loaded Owners");

        Vet vet = new Vet();

        vet.setFirstName("doctor");
        vet.setLastName("pashupathi");
        vetServiceMap.save(vet);

        Vet vet1 = new Vet();

        vet1.setFirstName("doctor");
        vet1.setLastName("pashupathi1");
        vetServiceMap.save(vet1);

        System.out.println("Loaded Vets");


    }
}
