package guru.springframework.sfgpetclinic1.model.services.map;

import guru.springframework.sfgpetclinic1.model.Speciality;
import guru.springframework.sfgpetclinic1.model.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecialityServiceMap extends AbstractMapservice<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);

    }

    @Override
    public Speciality findByID(Long id) {
        return findByID(id);
    }
}
