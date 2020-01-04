package org.exercice.diagnostic;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.exercice.diagnostic.dao.MaladieRepository;
import org.exercice.diagnostic.dao.MedicamentRepository;
import org.exercice.diagnostic.model.Diagnostic;
import org.exercice.diagnostic.model.Maladie;
import org.exercice.diagnostic.model.Medicament;
import org.exercice.diagnostic.model.Symptome;
import org.exercice.diagnostic.services.MaladieService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MedecinTest {

  public static Maladie maladie;
  public static Symptome symptome;
  public static List<Maladie> maladies;
  public static List<String> symptomes;
  public static List<Diagnostic> diagnostique;
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MaladieService maladieService;

  @MockBean
  private MaladieRepository maladieRepository;

  @MockBean
  private MedicamentRepository medicamentRepository;

  @BeforeClass
  public static void setUp() {

    maladie = new Maladie();
    // Creer symptome

    Symptome symptome = new Symptome();
    symptome.setSymptome("sensibilité au bruits");
    symptome.setId(5l);

    
    
    // Creer medicament 1

    Medicament medicament = new Medicament();
    medicament.setNom_medicament("doliprane");
    medicament.setId(5l);

    maladie.setId(1L);
    maladie.setNom_maladie("migraine1");
    maladie.getSymptomes().add(symptome);
    maladie.getMedicaments().add(medicament);
    maladies = Arrays.asList(maladie);

  }

  @Test
  public void return_maladies_when_get_maladies() throws Exception {

    // given
    given(maladieService.getAllMaladies()).willReturn(maladies);

    // when + then
    this.mockMvc.perform(get("/api/v1/maladies")).andExpect(status().isOk()).andExpect(content().json(
        "[{'nom_maladie':'migraine1'}]"));
  }


}
