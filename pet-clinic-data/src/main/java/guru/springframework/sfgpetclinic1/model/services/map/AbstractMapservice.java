package guru.springframework.sfgpetclinic1.model.services.map;



import guru.springframework.sfgpetclinic1.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapservice<T extends BaseEntity,ID extends Long>  {
    protected Map<Long,T> map = new HashMap<>();
    Set<T> findAll(){

        return new HashSet(map.values());
    }
    T findByID( ID id){
        return map.get(id);
    }
    T save (T object){
        if(object !=null){
            if(object.getId() == null){
                object.setId(getNextID());
                map.put(object.getId(),object);
            }
        }else{
            throw new RuntimeException("object cannot be null");
        }

        return object;
    }
    void delete(T object){

        map.entrySet().removeIf(entry1->entry1.getValue().equals(object));

    }
    void deleteByID(ID id){
        map.remove(id);
    }
    private Long getNextID(){
        Long id = null;
        try{
            id =Collections.max(map.keySet())+1;
        }catch(NoSuchElementException exception){
              id =1L;
        }
        return id;
    }
}
