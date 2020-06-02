package guru.springframework.sfgpetclinic1.model.repositories;

import guru.springframework.sfgpetclinic1.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    public Owner findByLastName(String lastName);
}
