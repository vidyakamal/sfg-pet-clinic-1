package guru.springframework.sfgpetclinic1.model.services.map;


import guru.springframework.sfgpetclinic1.model.Vet;
import guru.springframework.sfgpetclinic1.model.services.SpecialityService;
import guru.springframework.sfgpetclinic1.model.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapservice<Vet,Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if(object !=null){
            if (object.getSpecialitySet().size() >0) {
                object.getSpecialitySet().forEach(speciality -> {
                    if(speciality.getId() == null){
                         speciality.setId(specialityService.save(speciality).getId());
                    }
                });
            }
        }

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
