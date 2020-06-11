package guru.springframework.sfgpetclinic1.model.services.map;

import guru.springframework.sfgpetclinic1.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).lastName("smith").build());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner2 = Owner.builder().id(id).lastName("karen").build();
        Owner savedOwner =ownerServiceMap.save(owner2);
        System.out.println(savedOwner.getId());
        assertEquals(id, savedOwner.getId());
    }
    @Test

    void saveNoId(){
      Owner owner3 = ownerServiceMap.save( Owner.builder().build());
        System.out.println(owner3.getId());
        assertNotNull(owner3.getId());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findByID(1L));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteByID() {
        ownerServiceMap.deleteByID(1L);
        assertEquals(0,ownerServiceMap.findAll().size());

    }

    @Test
    void findByID() {
        Owner owner= ownerServiceMap.findByID(1L);
        assertEquals(owner.getId(),1L);
    }

    @Test
    void findByLastName() {
       Owner owner= ownerServiceMap.findByLastName("smith");
       assertNotNull(owner);
        assertEquals(owner.getId(),1L);
    }
}