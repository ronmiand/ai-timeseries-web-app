package com.upc.ai.timeseries.prediction.service;

import java.util.List;

import com.upc.ai.timeseries.prediction.dto.PrediccionDTO;

public interface IPredictionService {

	List<PrediccionDTO> obtenerPrediccion(String departamento);

}
