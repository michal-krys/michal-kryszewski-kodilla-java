package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<String, Double>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double meanTemp() {
        int count = 0;
        double sum = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
            count++;
            }
            if (count > 0) {
                return sum / count;
            } else {
                return 0;
            }
        }


    public double medianTemp() {
        List<Double> temperaturesList = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperaturesList);

        int count = temperaturesList.size();

        if (count == 0){
            return 0;
        }

        if (count % 2 == 1) {
            return temperaturesList.get(count / 2);
        } else {
            return (temperaturesList.get(count / 2 - 1) + temperaturesList.get(count / 2)) / 2;
        }
    }
}