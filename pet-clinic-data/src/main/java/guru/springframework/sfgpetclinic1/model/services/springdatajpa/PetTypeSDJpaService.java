package guru.springframework.sfgpetclinic1.model.services.springdatajpa;

import guru.springframework.sfgpetclinic1.model.PetType;
import guru.springframework.sfgpetclinic1.model.repositories.PetRepository;
import guru.springframework.sfgpetclinic1.model.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic1.model.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository pettypeRepository;

    public PetTypeSDJpaService(PetTypeRepository pettypeRepository) {
        this.pettypeRepository = pettypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set petSet = new HashSet();
        pettypeRepository.findAll().forEach(petSet::add);
        return petSet;

    }

    @Override
    public PetType findByID(Long aLong) {
        return pettypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return pettypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        pettypeRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        pettypeRepository.deleteById(aLong);

    }
}
