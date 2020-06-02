package guru.springframework.sfgpetclinic1.model.services.springdatajpa;

import guru.springframework.sfgpetclinic1.model.Pet;
import guru.springframework.sfgpetclinic1.model.repositories.PetRepository;
import guru.springframework.sfgpetclinic1.model.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {
    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> petSet = new HashSet<>();

       petRepository.findAll().forEach(petSet::add);
       return petSet;
    }

    @Override
    public Pet findByID(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);

    }


}
