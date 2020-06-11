package guru.springframework.sfgpetclinic1.model.services.springdatajpa;

import guru.springframework.sfgpetclinic1.model.Owner;
import guru.springframework.sfgpetclinic1.model.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic1.model.repositories.PetRepository;
import guru.springframework.sfgpetclinic1.model.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
   PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    Owner returnedOwner;


    @BeforeEach
    void setUp() {
         returnedOwner = Owner.builder().id(1L).lastName("Smith").build();
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
       Owner  smith = ownerSDJpaService.findByLastName("Smith");
       assertEquals("smith", smith.getLastName());

    }

    @Test
    void findAll() {
        Set ownerSet = new HashSet<>();
        Owner owner1 = Owner.builder().id(2L).lastName("Mat").build();
        Owner owner2 = Owner.builder().id(3L).lastName("Bill").build();
        ownerSet.add(owner1);
        ownerSet.add(owner2);
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set ownerSet2 = ownerSDJpaService.findAll();
        assertEquals(ownerSet2.size(),2);



    }

    @Test
    void findByID() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerSDJpaService.findByID(1L);
        assertNotNull(owner);
        verify(ownerRepository).save(any());


    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner savedOwner= ownerSDJpaService.save(Owner.builder().id(2L).lastName("Jack").build());

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnedOwner);

    }

    @Test
    void deleteByID() {
    }
}