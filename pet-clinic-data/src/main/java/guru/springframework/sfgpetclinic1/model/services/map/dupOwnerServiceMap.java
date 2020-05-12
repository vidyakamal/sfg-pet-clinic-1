package guru.springframework.sfgpetclinic1.model.services.map;

import guru.springframework.sfgpetclinic1.model.Owner;
import guru.springframework.sfgpetclinic1.model.services.CrudService;
import guru.springframework.sfgpetclinic1.model.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

public class dupOwnerServiceMap extends AbstractMapservice<Owner, Long > implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return null;
    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public Owner save(Owner object) {
        return null;
    }

    @Override
    public Owner findByID(Long id) {
        return null;
    }
}
