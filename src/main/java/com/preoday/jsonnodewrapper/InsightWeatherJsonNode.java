package com.preoday.jsonnodewrapper;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.preoday.utils.TemperatureUtils;

public class InsightWeatherJsonNode {
	
	private static final String SOL_KEYS_FIELD = "sol_keys";
	
	private JsonNode jsonNode;

	public InsightWeatherJsonNode() {
		super();
	}
	
	public InsightWeatherJsonNode(JsonNode jsonNode) {
		super();
		this.jsonNode = jsonNode;
	}

	public ArrayList<String> getSolKeys() {
		ArrayList<String> solKeys = new ArrayList<String>();
		
		ArrayNode solKeysArrayNode = jsonNode.withArray(SOL_KEYS_FIELD);
		for (JsonNode solKey : solKeysArrayNode) {
			solKeys.add(solKey.asText());
		}
		
		return solKeys;
	}
	
	public Boolean existsSol(String sol) {
		return sol != null && getSolKeys().contains(sol);
	}
	
	public SolJsonNode getSol(String sol) {
		JsonNode solJsonNode = jsonNode.get(sol);
		return new SolJsonNode(solJsonNode);
	}
	
	public Double getAverageOfAllSols() {
		Double averageTemperature = 0.0;
		ArrayList<String> solKeys = getSolKeys();
		for (String solKey : solKeys) {
			Double solAverage = getSol(solKey).getAtmosphereTemperature().getAverageTemperature();
			averageTemperature += TemperatureUtils.celsiusToFahrenheit(solAverage);
		}
		return averageTemperature / solKeys.size();
	}
	
	public Double getAverageTemperature(String sol) {
		Double solAverage = getSol(sol).getAtmosphereTemperature().getAverageTemperature();
		return TemperatureUtils.celsiusToFahrenheit(solAverage);
	}
	
}
