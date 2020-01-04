package org.exercice.diagnostic.dao;

import java.util.List;

import org.exercice.diagnostic.model.Maladie;
import org.exercice.diagnostic.model.Symptome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomeRepository extends JpaRepository<Symptome, Long> {
  
  @Query("select m.maladies from Symptome m where m.symptome like :x  ")
  public List<Maladie> findBySymptome(@Param("x") String name);

}
