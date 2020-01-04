package org.exercice.diagnostic.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.exercice.diagnostic.dao.MaladieRepository;
import org.exercice.diagnostic.dao.SymptomeRepository;
import org.exercice.diagnostic.model.Diagnostic;
import org.exercice.diagnostic.model.Maladie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaladieService {

  @Autowired
  private SymptomeRepository symptomeRepository;

  @Autowired
  private MaladieRepository maladieRepository;

  public List<Diagnostic> calculateProbalitesFromSymptomes(List<String> symptomes) {
    return getProbalitesFromSymptomes(symptomes).stream()
        .sorted(Comparator.comparingDouble(Diagnostic::getProbabilite).reversed()).collect(Collectors.toList());
  }

  // methode pour donner une liste de maladie probable a partir d'une liste de
  // symptome
  private List<Diagnostic> getProbalitesFromSymptomes(List<String> symptomes) {
    List<Diagnostic> resultat = new ArrayList<>();

    Map<Maladie, Integer> stats = new HashMap<>();
    int nbMaladies = 0;

    // la liste des maladie pour chaque syptome
    for (String symptome : symptomes) {
      List<Maladie> maladies = getMaladiesFromSymptome(symptome);

      for (Maladie maladie : maladies) {
        if (stats.containsKey(maladie)) {
          int occurences = stats.get(maladie);
          stats.put(maladie, occurences + 1);

        } else {
          stats.put(maladie, 1);
          nbMaladies++;

        }
      }

    }

    // preparer la liste des maladies avec leurs probabilitées
    for (Entry<Maladie, Integer> entry : stats.entrySet()) {
      if (nbMaladies != 0) {
        float probabilite = (entry.getValue().floatValue() / nbMaladies) * 100;
        Diagnostic diagnostic = new Diagnostic(entry.getKey().getNom_maladie(), probabilite);

        resultat.add(diagnostic);
      }
    }

    return resultat;
  }

  private List<Maladie> getMaladiesFromSymptome(String symptome) {

    return symptomeRepository.findBySymptome("%"+symptome+"%");
  }

  public List<Maladie> getAllMaladies() {
    return maladieRepository.findAll();
  }

  public Optional<Maladie> getMaladieById(Long id) {
    return maladieRepository.findById(id);
  }

  public Maladie maladieByName(String nomMaladie) {
    return maladieRepository.findByNomMaladie(nomMaladie);
  }
}
