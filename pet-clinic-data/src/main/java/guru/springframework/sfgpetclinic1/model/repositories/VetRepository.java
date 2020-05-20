package guru.springframework.sfgpetclinic1.model.repositories;

import guru.springframework.sfgpetclinic1.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
