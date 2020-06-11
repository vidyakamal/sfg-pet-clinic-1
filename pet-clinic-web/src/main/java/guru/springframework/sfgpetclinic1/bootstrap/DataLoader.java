package guru.springframework.sfgpetclinic1.bootstrap;

import guru.springframework.sfgpetclinic1.model.*;
import guru.springframework.sfgpetclinic1.model.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService pettypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService pettypeService, SpecialityService specialityService, VisitService visitService) {
        this.pettypeService = pettypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = pettypeService.findAll().size();

        if(count == 0) {

            loadData();
        }

    }

    private void loadData() {
        PetType pettype = new PetType();
        pettype.setName("dog");
        PetType savedpettype = pettypeService.save(pettype);

        PetType pettype1 = new PetType();
        pettype.setName("cat");
        PetType savedpettype1 = pettypeService.save(pettype1);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedSpeciality = specialityService.save(dentistry);
        specialityService.save(dentistry);
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedSpeciality1 = specialityService.save(radiology);

        Owner owner = new Owner();

        owner.setFirstName("gafoor");
        owner.setLastName("Ikka");
        owner.setAddress("3362 Norwood Avenue");
        owner.setCity("SJ");
        owner.setTelephone("1234");


        Pet gafoorPet = new Pet();
        gafoorPet.setName("Luna");
        gafoorPet.setPetType(savedpettype);
        gafoorPet.setBirthDay(LocalDate.now());
        gafoorPet.setOwner(owner);
        owner.getPets().add(gafoorPet);
        ownerService.save(owner);

        Visit visit = new Visit();
        visit.setPet(gafoorPet);
        visit.setDate(LocalDate.now());
        visit.setDescription("wellness");
        visitService.save(visit);


        Owner owner1 = new Owner();

        owner1.setFirstName("cid");
        owner1.setLastName("vijayan");
        owner1.setAddress("3362 Norwood Avenue");
        owner1.setCity("SJ");
        owner1.setTelephone("1234");
        Pet viPett = new Pet();
        viPett.setName("Leiya");
        viPett.setPetType(savedpettype1);
        viPett.setBirthDay(LocalDate.now());
        viPett.setOwner(owner1);
        owner1.getPets().add(viPett);
        ownerService.save(owner1);

        System.out.println("Loaded Owners");

        Vet vet = new Vet();

        vet.setFirstName("doctor");
        vet.setLastName("pashupathi");
        vet.getSpecialitySet().add(savedSpeciality);
        vetService.save(vet);

        Vet vet1 = new Vet();

        vet1.setFirstName("doctor");
        vet1.setLastName("pashupathi1");
        vet1.getSpecialitySet().add(savedSpeciality1);
        vetService.save(vet1);

        System.out.println("Loaded Vets");
    }
}
