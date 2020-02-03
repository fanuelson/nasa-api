package com.preoday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.preoday.apirequest.NasaApiRequester;
import com.preoday.vo.TemperatureResponseVO;

@Service()
public class NasaService {

	@Autowired
	private NasaApiRequester nasaApiRequester;
	
	private Boolean checkIfExists(ArrayNode arrayNode, Object value) {
		for (JsonNode element : arrayNode) {
			if(element.asText().equals(value)) {
				return true;
			}
			
		}
		return false;
	}

	public TemperatureResponseVO getMarsTemperatureAverage(Integer sol) {
		JsonNode nasaApiResponse = nasaApiRequester.requestMarsWeather();

		ArrayNode solKeys = nasaApiResponse.withArray("sol_keys");

		Double averageTemperature = 0.0;
		if (sol != null && checkIfExists(solKeys, String.valueOf(sol))) {
			averageTemperature = nasaApiResponse.get(String.valueOf(sol)).get("AT").get("av").asDouble();
		} else {
			for (JsonNode solKey : solKeys) {
				Double average = nasaApiResponse.get(solKey.asText()).get("AT").get("av").asDouble();
				averageTemperature += average;
			}
			averageTemperature = averageTemperature / solKeys.size();
		}
		
		return new TemperatureResponseVO(averageTemperature);
	}
}
