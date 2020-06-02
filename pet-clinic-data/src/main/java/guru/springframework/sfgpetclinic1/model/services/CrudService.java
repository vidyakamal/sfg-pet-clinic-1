package guru.springframework.sfgpetclinic1.model.services;

import java.util.Set;

public interface CrudService <T1,ID1>{
    Set<T1> findAll();
    T1 findByID( ID1 id);
    T1 save (T1 object);
    void delete(T1 object);
    void deleteByID(ID1 id);
}
