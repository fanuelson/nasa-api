package com.preoday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preoday.apirequest.NasaApiRequester;
import com.preoday.jsonnodewrapper.InsightWeatherJsonNode;
import com.preoday.vo.TemperatureResponseVO;

@Service()
public class NasaService {

	@Autowired
	private NasaApiRequester nasaApiRequester;
	
	public TemperatureResponseVO getMarsTemperatureAverage(Integer sol) {
		InsightWeatherJsonNode nasaApiResponse = nasaApiRequester.requestMarsWeather();
		String solString = sol == null ? null : String.valueOf(sol);
		
		Double averageTemperature = 0.0;
		if (nasaApiResponse.existsSol(solString)) {
			averageTemperature = nasaApiResponse.getAverageTemperature(solString);
		} else {
			averageTemperature = nasaApiResponse.getAverageOfAllSols();
		}
		
		return new TemperatureResponseVO(averageTemperature);
	}
}
