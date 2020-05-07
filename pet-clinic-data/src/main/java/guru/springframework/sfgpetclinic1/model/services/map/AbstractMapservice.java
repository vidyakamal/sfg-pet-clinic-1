package guru.springframework.sfgpetclinic1.model.services.map;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapservice<T,ID>  {
    protected Map<ID,T> map = new HashMap<>();
    Set<T> findAll(){

        return new HashSet(map.values());
    }
    T findByID( ID id){
        return map.get(id);
    }
    T save (ID id,T object){
        map.put(id,object);
        return object;
    }
    void delete(T object){

        map.entrySet().removeIf(entry1->entry1.getValue().equals(object));

    }
    void deleteByID(ID id){
        map.remove(id);
    }
}
