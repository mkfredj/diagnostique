package org.exercice.diagnostic.controller;

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
import org.exercice.diagnostic.model.Symptome;
import org.exercice.diagnostic.services.MaladieService;
import org.exercice.diagnostic.services.SymptomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Systeme de diagnostique de maladie")

public class Medecin {

  @Autowired
  private MaladieService maladieService;

  @Autowired
  private SymptomeService symptomeService;

  @ApiOperation(value = "lister les maladies", response = List.class)
  @GetMapping("/maladies")
  public List<Maladie> getMaladies() {

    return maladieService.getAllMaladies();
  }

  @ApiOperation(value = "retoutner une maladie a partir de son identifiant")
  @GetMapping("/maladies/{id}")
  public Optional<Maladie> getMaladie(
      @ApiParam(value = "le code de la maladie a retourner ", required = true) @PathVariable(name = "id") Long id) {

    return maladieService.getMaladieById(id);
  }

  @ApiOperation(value = "retoutner une maladie a partir de son nom")
  @GetMapping("maladies/maladie/{nomMaladie}")
  public Maladie getMaladieByName(
      @ApiParam(value = "le nom de la maladie a retourner ", required = true) @PathVariable(name = "nomMaladie") String nomMaladie) {

    return maladieService.maladieByName(nomMaladie);
  }

  @ApiOperation(value = "lister les symptomes", response = List.class)
  @GetMapping("/symtpomes")
  public List<Symptome> getSymptomes() {

    return symptomeService.getAllSymptomes();
  }

  
  @ApiOperation(value = "retoutner la liste des maladies probables a partir d'une listes des symptomes", response = List.class)
  @GetMapping("/maladies/symptomes/{symptomes}")
  public List<Diagnostic> diagnostiquer(
      @ApiParam(value = "la liste des symptomes  ", required = true) @PathVariable(name = "symptomes") List<String> symptomes) {

    return maladieService.calculateProbalitesFromSymptomes(symptomes);

  }
}
