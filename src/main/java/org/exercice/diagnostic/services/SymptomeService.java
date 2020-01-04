package org.exercice.diagnostic.services;

import java.util.List;

import org.exercice.diagnostic.dao.SymptomeRepository;
import org.exercice.diagnostic.model.Symptome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomeService {
  @Autowired
  private SymptomeRepository symptomeRepository;

  public List<Symptome> getAllSymptomes() {
    return symptomeRepository.findAll();
  }
  
}
