package org.exercice.diagnostic;

import javax.servlet.ServletContext;

import org.exercice.diagnostic.dao.MaladieRepository;
import org.exercice.diagnostic.dao.MedicamentRepository;
import org.exercice.diagnostic.dao.SymptomeRepository;
import org.exercice.diagnostic.model.Maladie;
import org.exercice.diagnostic.model.Medicament;
import org.exercice.diagnostic.model.Symptome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DiagnosticApplication implements CommandLineRunner {

  @Autowired
  private MedicamentRepository medicamentRepository;

  @Autowired
  private SymptomeRepository symptomeRepository;

  @Autowired
  private MaladieRepository maladieRepository;

  @Autowired
  ServletContext servletContext;

  public static void main(String[] args) {
    SpringApplication.run(DiagnosticApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub

    // Creer maladie 1
    Maladie maladie = new Maladie();
    maladie.setNom_maladie("migraine");

    // Creer maladie 2
    Maladie maladie2 = new Maladie();
    maladie2.setNom_maladie("gastro");

    // Creer maladie 3
    Maladie maladie3 = new Maladie();
    maladie3.setNom_maladie("bronchite");

    // Creer maladie 3
    Maladie maladie4 = new Maladie();
    maladie4.setNom_maladie("migraine1");

    // Creer symptome1
    Symptome symptome = new Symptome();
    symptome.setSymptome("nausées");

    // Creer symptome2
    Symptome symptome2 = new Symptome();
    symptome2.setSymptome("cephalées");

    // Creer symptome3
    Symptome symptome3 = new Symptome();
    symptome3.setSymptome("vaumissement");

    // Creer symptome4
    Symptome symptome4 = new Symptome();
    symptome4.setSymptome("sensibilité au bruits");

    // Creer medicament 1
    Medicament medicament = new Medicament();
    medicament.setNom_medicament("doliprane");

    // Creer medicament 2
    Medicament medicament2 = new Medicament();
    medicament2.setNom_medicament("fervex");

    // Creer medicament 3
    Medicament medicament3 = new Medicament();
    medicament3.setNom_medicament("econazole");

    maladie.getSymptomes().add(symptome);
    maladie.getSymptomes().add(symptome2);
    maladie.getSymptomes().add(symptome3);
    maladie.getMedicaments().add(medicament3);
    maladie.getMedicaments().add(medicament2);

    maladie2.getSymptomes().add(symptome);
    maladie2.getSymptomes().add(symptome3);
    maladie2.getMedicaments().add(medicament);
    maladie2.getMedicaments().add(medicament2);
    maladie2.getMedicaments().add(medicament3);

    maladie3.getSymptomes().add(symptome);
    maladie3.getSymptomes().add(symptome2);
    maladie3.getSymptomes().add(symptome4);
    maladie3.getMedicaments().add(medicament);

    maladie4.getSymptomes().add(symptome4);
    maladie4.getMedicaments().add(medicament);
    symptomeRepository.save(symptome);
    symptomeRepository.save(symptome2);
    symptomeRepository.save(symptome3);
    symptomeRepository.save(symptome4);

    medicamentRepository.save(medicament);
    medicamentRepository.save(medicament2);
    medicamentRepository.save(medicament3);

    maladieRepository.save(maladie);
    maladieRepository.save(maladie2);
    maladieRepository.save(maladie3);
    maladieRepository.save(maladie4);
  }
}
