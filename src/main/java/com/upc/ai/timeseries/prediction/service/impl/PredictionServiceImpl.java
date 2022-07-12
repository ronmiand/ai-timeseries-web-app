package com.upc.ai.timeseries.prediction.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.upc.ai.timeseries.prediction.dto.PrediccionDTO;
import com.upc.ai.timeseries.prediction.service.IPredictionService;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.classifiers.functions.GaussianProcesses;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.timeseries.WekaForecaster;
//import weka.classifiers.timeseries.core.TSLagMaker;
import weka.filters.supervised.attribute.TSLagMaker;
import org.springframework.util.ResourceUtils;

@Service
public class PredictionServiceImpl implements IPredictionService {

	@Override
	public List<PrediccionDTO> obtenerPrediccion(String departamento) {
		try {
			// path to the Australian wine data included with the time series forecasting
			// package
//			Resource resource = new ClassPathResource("Lima.arff");
//			InputStream input = resource.getInputStream();
//			File file = resource.getFile();
			
			File file2 = ResourceUtils.getFile("classpath:Lima.arff");
			
			// load the wine data
//			Instances lima = new Instances(new BufferedReader(new FileReader(pathToWineData)));
			Instances lima = new Instances(new BufferedReader(new FileReader(file2)));
			System.out.println(lima.size());

			// new forecaster
			WekaForecaster forecaster = new WekaForecaster();

			// set the targets we want to forecast. This method calls
			// setFieldsToLag() on the lag maker object for us
			forecaster.setFieldsToForecast("AlumnosMatriculadosPublica,AlumnosMatriculadosPrivada,PBI");

			// default underlying classifier is SMOreg (SVM) - we'll use
			// gaussian processes for regression instead
			forecaster.setBaseForecaster(new LinearRegression());

			forecaster.getTSLagMaker().setTimeStampField("Year"); // date time stamp
			forecaster.getTSLagMaker().setMinLag(1);
			forecaster.getTSLagMaker().setMaxLag(5); // monthly data

			// add a month of the year indicator field
			// forecaster.getTSLagMaker().setAddMonthOfYear(true);

			// add a quarter of the year indicator field
			// forecaster.getTSLagMaker().setAddQuarterOfYear(true);

			// build the model
			forecaster.buildForecaster(lima, System.out);

			// prime the forecaster with enough recent historical data
			// to cover up to the maximum lag. In our case, we could just supply
			// the 12 most recent historical instances, as this covers our maximum
			// lag period
			forecaster.primeForecaster(lima);

			// forecast for 12 units (months) beyond the end of the
			// training data
			List<List<NumericPrediction>> forecast = forecaster.forecast(6, System.out);

			// output the predictions. Outer list is over the steps; inner list is over
			// the targets
			for (int i = 0; i < 6; i++) {
				List<NumericPrediction> predsAtStep = forecast.get(i);
				for (int j = 0; j < 4; j++) {
					NumericPrediction predForTarget = predsAtStep.get(j);
					System.out.print("" + predForTarget.predicted() + " ");
				}
				System.out.println();
			}

			// we can continue to use the trained forecaster for further forecasting
			// by priming with the most recent historical data (as it becomes available).
			// At some stage it becomes prudent to re-build the model using current
			// historical data.

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
	}
}
