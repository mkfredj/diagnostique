package org.exercice.diagnostic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.exercice.diagnostic.dao.MaladieRepository;
import org.exercice.diagnostic.model.Maladie;
import org.exercice.diagnostic.services.MaladieService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DiagnosticApplicationTests {
  @Mock
  private MaladieRepository maladieRepository;

  @Mock
  private MaladieService maladieService;

  @BeforeClass
  public static void classSetUp() {
  }
  
  @Before
  public void setUp() throws Exception {

    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void GetMaladieByIdTest() {
    Maladie maladie = new Maladie();
    maladie.setId(8L);
    maladie.setNom_maladie("aaaa");
    when(maladieRepository.findById(8L)).thenReturn(Optional.of(maladie));
    assertTrue("aaaa".equals(maladieRepository.findById(8L).get().getNom_maladie()));

  }

  @Test
  public void GetMaladiesTest() {
    List<Maladie> maladies = new ArrayList<Maladie>();

    Maladie maladie = new Maladie();
    maladie.setId(8L);
    maladie.setNom_maladie("aaaa");
    Maladie maladie1 = new Maladie();
    maladie1.setId(9L);
    maladie1.setNom_maladie("bbbb");
    maladies.add(maladie);
    maladies.add(maladie1);
    when(maladieRepository.findAll()).thenReturn(maladies);
    assertTrue("aaaa".equals(maladies.get(0).getNom_maladie()));
    assertTrue("bbbb".equals(maladies.get(1).getNom_maladie()));
    assertTrue((Integer.valueOf(2).equals(maladies.size())));

  }

  @Test
  public void getProbalitesFromSymptomesTest() {
    List<String> symptomes = new ArrayList<>();
    symptomes.add("nausées");
    symptomes.add("cephalées");
    assertThat("migraine".equals(maladieService.calculateProbalitesFromSymptomes(symptomes)));
  }

}
