package guru.springframework.sfgpetclinic1.model.services.springdatajpa;

import guru.springframework.sfgpetclinic1.model.Owner;
import guru.springframework.sfgpetclinic1.model.Vet;
import guru.springframework.sfgpetclinic1.model.repositories.VetRepository;
import guru.springframework.sfgpetclinic1.model.services.OwnerService;
import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    private final VetRepository vetRepository;

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetRepository.findAll().forEach(vetSet :: add);
        return vetSet;
    }

    @Override
    public Vet findByID(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        vetRepository.deleteById(aLong);

    }
}