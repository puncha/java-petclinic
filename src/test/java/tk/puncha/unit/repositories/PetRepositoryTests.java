package tk.puncha.unit.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tk.puncha.dao.PetDAO;
import tk.puncha.dao.PetTypeDAO;
import tk.puncha.models.Pet;
import tk.puncha.models.PetType;
import tk.puncha.repositories.PetRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PetRepositoryTests {

  @Mock
  private Pet petMock;
  @Mock
  private List<Pet> petListMock;
  @Mock
  private PetDAO petDAOMock;
  @Mock
  private PetTypeDAO petTypeDAOMock;
  @Mock
  private List<PetType> petTypeListMock;
  @InjectMocks
  private PetRepository petRepository;

  @Test
  public void shouldGetAllPetsDispatchCallToDAO() throws Exception {
    when(petDAOMock.getAll()).thenReturn(petListMock);
    assertEquals(petListMock, petRepository.getAllPets());
    verify(petDAOMock).getAll();
    verifyNoMoreInteractions(petDAOMock);
  }

  @Test
  public void shouldGetPetByIdDispatchCallToDAO() throws Exception {
    when(petDAOMock.getById(anyInt())).thenReturn(petMock);
    assertEquals(petMock, petRepository.getPetById(anyInt()));
    verify(petDAOMock).getById(anyInt());
    verifyNoMoreInteractions(petDAOMock);
  }

  @Test
  public void shouldGetAllTypesDispatchCallToDAO() throws Exception {
    when(petTypeDAOMock.getAll()).thenReturn(petTypeListMock);
    assertEquals(petTypeListMock, petRepository.getAllTypes());
    verify(petTypeDAOMock).getAll();
    verifyNoMoreInteractions(petDAOMock, petTypeDAOMock);
  }

  @Test
  public void shouldInsertDispatchCallToDAO() throws Exception {
    when(petDAOMock.insert(any(Pet.class))).thenReturn(123);
    assertEquals(123, petRepository.insertPet(any(Pet.class)));
    verify(petDAOMock).insert(any(Pet.class));
    verifyNoMoreInteractions(petDAOMock);
  }

  @Test
  public void shouldUpdateDispatchCallToDAO() throws Exception {
    doNothing().when(petDAOMock).update(any(Pet.class));
    petRepository.updatePet(any(Pet.class));
    verify(petDAOMock).update(any(Pet.class));
  }

  @Test
  public void shouldDeleteByIdDispatchCallToDAO() throws Exception {
    doNothing().when(petDAOMock).deleteById(anyInt());
    petRepository.delete(anyInt());
    verify(petDAOMock).deleteById(anyInt());
    verifyNoMoreInteractions(petDAOMock);
  }

  @Test
  public void shouldDeleteByOwnerIdDispatchCallToDAO() throws Exception {
    doNothing().when(petDAOMock).deleteByOwnerId(anyInt());
    petRepository.deletePetsByOwnerId(anyInt());
    verify(petDAOMock).deleteByOwnerId(anyInt());
    verifyNoMoreInteractions(petDAOMock);
  }
}
