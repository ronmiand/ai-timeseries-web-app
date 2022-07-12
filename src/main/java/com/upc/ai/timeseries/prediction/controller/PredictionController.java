package com.upc.ai.timeseries.prediction.controller;

import com.upc.ai.timeseries.prediction.dto.PrediccionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import java.util.List;
/*
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.classifiers.functions.GaussianProcesses;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.timeseries.WekaForecaster;
//import weka.classifiers.timeseries.core.TSLagMaker;
import weka.filters.supervised.attribute.TSLagMaker;
*/
@RestController
public class PredictionController {
    @GetMapping( name = "/obtener-predicciones/{departamento}")
    public ResponseEntity<PrediccionDTO> obtenerPredicciones( @PathVariable("departamento") String departamento) {
         List<PrediccionDTO> list = null;

        return  new ResponseEntity(list, HttpStatus.OK);
    }
/*
    public static void main(String[] args) {
        try {
            // path to the Australian wine data included with the time series forecasting
            // package
            String pathToWineData = "D:\\upc\\Inteligencia Artificial\\Trabajo Grupal\\data\\Lima.arff";

            // load the wine data
            Instances lima = new Instances(new BufferedReader(new FileReader(pathToWineData)));
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
            //forecaster.getTSLagMaker().setAddMonthOfYear(true);

            // add a quarter of the year indicator field
            //forecaster.getTSLagMaker().setAddQuarterOfYear(true);

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
    }

 */
}
