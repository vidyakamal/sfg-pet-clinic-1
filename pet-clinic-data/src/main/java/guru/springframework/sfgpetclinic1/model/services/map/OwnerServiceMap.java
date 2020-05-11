package guru.springframework.sfgpetclinic1.model.services.map;

import guru.springframework.sfgpetclinic1.model.services.CrudService;
import guru.springframework.sfgpetclinic1.model.services.OwnerService;
import guru.springframework.sfgpetclinic1.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapservice<Owner,Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save( Owner object) {
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
        return null;
    }
}
