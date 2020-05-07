package guru.springframework.sfgpetclinic1.model.services.map;



import guru.springframework.sfgpetclinic1.model.Pet;
import guru.springframework.sfgpetclinic1.model.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetServiceMap extends AbstractMapservice<Pet,Long> implements CrudService<Pet,Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
      super.deleteByID(id);
    }

    @Override
    public void delete(Pet object) {
super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }
}
