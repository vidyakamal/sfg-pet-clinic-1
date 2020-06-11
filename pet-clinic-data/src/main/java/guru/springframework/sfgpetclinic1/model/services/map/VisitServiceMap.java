package guru.springframework.sfgpetclinic1.model.services.map;

import guru.springframework.sfgpetclinic1.model.Visit;
import guru.springframework.sfgpetclinic1.model.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapservice<Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);

    }

    @Override
    public void delete(Visit object) {
        super.delete(object);

    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() ==null || visit.getPet().getOwner() ==null
                || visit.getPet().getId()== null || visit.getPet().getOwner().getId() ==null)
            throw new RuntimeException("invalid visit");
        return super.save(visit);
    }

    @Override
    public Visit findByID(Long id) {
        return super.findByID(id);
    }
}
