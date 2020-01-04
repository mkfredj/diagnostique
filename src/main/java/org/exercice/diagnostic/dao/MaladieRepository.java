package org.exercice.diagnostic.dao;

import org.exercice.diagnostic.model.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Long> {
  
  public Maladie findByNomMaladie(String nom);
}
