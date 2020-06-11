package guru.springframework.sfgpetclinic1.model.services.map;



import guru.springframework.sfgpetclinic1.model.Pet;
import guru.springframework.sfgpetclinic1.model.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractMapservice<Pet,Long> implements PetService {

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
        return super.save(object);
    }

    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }
}
