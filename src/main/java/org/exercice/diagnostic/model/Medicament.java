package org.exercice.diagnostic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "les details d'un medicament ")
public class Medicament implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue
  @ApiModelProperty(notes = "l'id de la maladie generer automatiquement")
  @JsonIgnore
  private long id;

  @ApiModelProperty(notes = "le nom du medicament")
  private String nom_medicament;

  @ManyToMany(mappedBy = "medicaments")
  @ApiModelProperty(notes = "la liste des maldies pouvant utiliser ce medicament")
  @JsonIgnore
  private List<Maladie> maladies = new ArrayList<Maladie>();

  public Medicament() {
    super();
    // TODO Auto-generated constructor stub
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNom_medicament() {
    return nom_medicament;
  }

  public void setNom_medicament(String nom_medicament) {
    this.nom_medicament = nom_medicament;
  }

  public List<Maladie> getMaladies() {
    return maladies;
  }

  public void setMaladies(List<Maladie> maladies) {
    this.maladies = maladies;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }


}
