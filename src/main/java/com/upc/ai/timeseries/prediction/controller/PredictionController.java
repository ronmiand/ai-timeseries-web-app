package com.upc.ai.timeseries.prediction.controller;

import com.upc.ai.timeseries.prediction.dto.PrediccionDTO;
import com.upc.ai.timeseries.prediction.service.IPredictionService;
import com.upc.ai.timeseries.prediction.service.impl.PredictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import java.util.List;

@RestController
public class PredictionController {
    @Autowired
    IPredictionService iPredictionService;
    @GetMapping( name = "/obtener-predicciones/{departamento}")
    public ResponseEntity<PrediccionDTO> obtenerPredicciones( @PathVariable("departamento") String departamento) {
         List<PrediccionDTO> list = iPredictionService.obtenerPrediccion(departamento);

        return  new ResponseEntity(list, HttpStatus.OK);
    }
}
