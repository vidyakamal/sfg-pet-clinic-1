package guru.springframework.sfgpetclinic1.model.services.map;

import guru.springframework.sfgpetclinic1.model.Pet;
import guru.springframework.sfgpetclinic1.model.services.OwnerService;
import guru.springframework.sfgpetclinic1.model.Owner;
import guru.springframework.sfgpetclinic1.model.services.PetService;
import guru.springframework.sfgpetclinic1.model.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapservice<Owner,Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save( Owner object) {
        if(object != null) {
            System.out.println(object.getPets());
            if(object.getPets() != null){
                System.out.println("object.getPets() is not null");
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        System.out.println("PetType is not null");
                        if (pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Petytype is required");
                    }
                    if(pet.getId() ==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }else {
                System.out.println("object.getPets() is  null");
            }


        }
        return super.save(object);
    }


    @Override
    public void delete(Owner object) {
          super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }


    @Override
    public Owner findByID(Long id) {
        return  super.findByID(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
       return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }
}
