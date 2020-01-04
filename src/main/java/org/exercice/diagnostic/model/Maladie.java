package org.exercice.diagnostic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity

@ApiModel(description = "les details d'une maladie ")
public class Maladie implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue
  @ApiModelProperty(notes = "l'id d'une maladie generer automatiquement")
  @JsonIgnore
  private long id;
  
  @ApiModelProperty(notes = "le nom d'une maladie")
  private String nomMaladie;

  @ManyToMany
  @JoinTable(name = "maladie_symptomes", joinColumns = @JoinColumn(name = "maladie_id"), inverseJoinColumns = @JoinColumn(name = "symptome_id"))
  @ApiModelProperty(notes = "la liste des symptomes relatif a la maladie")
  @JsonIgnore
  private List<Symptome> symptomes = new ArrayList<Symptome>();

  @ManyToMany
  @JoinTable(name = "maladie_medicaments", joinColumns = @JoinColumn(name = "maladie_id"), inverseJoinColumns = @JoinColumn(name = "medicament_id"))
  @ApiModelProperty(notes = "la liste des medicaments relatif a une maladie")
  @JsonIgnore
  private List<Medicament> medicaments = new ArrayList<Medicament>();

  public Maladie() {
    super();
    // TODO Auto-generated constructor stub
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNom_maladie() {
    return nomMaladie;
  }

  public void setNom_maladie(String nom_maladie) {
    this.nomMaladie = nom_maladie;
  }

  public List<Symptome> getSymptomes() {
    return symptomes;
  }

  public void setSymptomes(List<Symptome> symptomes) {
    this.symptomes = symptomes;
  }

  public List<Medicament> getMedicaments() {
    return medicaments;
  }

  public void setMedicaments(List<Medicament> medicaments) {
    this.medicaments = medicaments;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }


}
