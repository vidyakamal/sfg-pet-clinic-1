package guru.springframework.sfgpetclinic1.model.services.map;


import guru.springframework.sfgpetclinic1.model.Vet;
import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapservice<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
    super.deleteByID(id);
    }

    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }
}
