package org.exercice.diagnostic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "les details d'un symptome ")
public class Symptome implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @ApiModelProperty(notes = "l'id du symptome generer automatiquement")
  @JsonIgnore
  private long id;

  @ApiModelProperty(notes = "le nom du symptome")
  private String symptome;

  @ManyToMany(mappedBy = "symptomes")
  @ApiModelProperty(notes = "lites des maladies pouvant manifester ces symptomes")
  @JsonIgnore
  private List<Maladie> maladies = new ArrayList<Maladie>();

  public Symptome() {
    super();
    // TODO Auto-generated constructor stub
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSymptome() {
    return symptome;
  }

  public void setSymptome(String symptome) {
    this.symptome = symptome;
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
