package guru.springframework.sfgpetclinic1.model.services.springdatajpa;

import guru.springframework.sfgpetclinic1.model.Visit;
import guru.springframework.sfgpetclinic1.model.repositories.VisitRepository;
import guru.springframework.sfgpetclinic1.model.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")

public class VisitSDJpaService implements VisitService {
private final VisitRepository visitRepository ;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set <Visit>visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findByID(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);

    }

    @Override
    public void deleteByID(Long id) {
        visitRepository.deleteById(id);

    }
}
