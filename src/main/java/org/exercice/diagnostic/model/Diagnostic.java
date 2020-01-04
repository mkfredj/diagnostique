package org.exercice.diagnostic.model;

public class Diagnostic {
  String maladie;
  float probabilite;

  public Diagnostic() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Diagnostic(String maladie, float probabilite) {
    super();
    this.maladie = maladie;
    this.probabilite = probabilite;
  }

  public String getMaladie() {
    return maladie;
  }

  public void setMaladie(String maladie) {
    this.maladie = maladie;
  }

  public float getProbabilite() {
    return probabilite;
  }

  public void setProbabilite(float probabilite) {
    this.probabilite = probabilite;
  }

  @Override
  public String toString() {
    return "Diagnostic [probabilite=" + probabilite + "]";
  }

}
