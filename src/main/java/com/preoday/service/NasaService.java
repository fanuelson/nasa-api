package com.preoday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.preoday.apirequest.NasaApiRequester;
import com.preoday.utils.TemperatureUtils;
import com.preoday.vo.TemperatureResponseVO;

@Service()
public class NasaService {

	private static final String SOL_KEYS_FIELD = "sol_keys";
	private static final String AV_FIELD = "av";
	private static final String AT_FIELD = "AT";
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

		ArrayNode solKeys = nasaApiResponse.withArray(SOL_KEYS_FIELD);

		Double averageTemperature = 0.0;
		if (sol != null && checkIfExists(solKeys, String.valueOf(sol))) {
			Double solAverage = nasaApiResponse.get(String.valueOf(sol)).get(AT_FIELD).get(AV_FIELD).asDouble();
			averageTemperature = TemperatureUtils.celsiusToFahrenheit(solAverage);
		} else {
			for (JsonNode solKey : solKeys) {
				Double solAverage = nasaApiResponse.get(solKey.asText()).get(AT_FIELD).get(AV_FIELD).asDouble();
				averageTemperature += TemperatureUtils.celsiusToFahrenheit(solAverage);
			}
			averageTemperature = averageTemperature / solKeys.size();
		}
		
		return new TemperatureResponseVO(averageTemperature);
	}
}
