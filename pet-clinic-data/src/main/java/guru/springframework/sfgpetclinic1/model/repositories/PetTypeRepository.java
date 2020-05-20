package guru.springframework.sfgpetclinic1.model.repositories;

import guru.springframework.sfgpetclinic1.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
