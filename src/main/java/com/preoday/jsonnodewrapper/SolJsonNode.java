package com.preoday.jsonnodewrapper;

import com.fasterxml.jackson.databind.JsonNode;

public class SolJsonNode {
	
	private static final String AT_FIELD = "AT";

	private JsonNode solJsonNode;
	
	public SolJsonNode() {
		
	}
	
	public SolJsonNode(JsonNode jsonNode) {
		this.solJsonNode = jsonNode;
	}
	
	public AtmosphericTemperatureJsonNode getAtmosphereTemperature() {
		JsonNode jsonNode = solJsonNode.get(AT_FIELD);
		return new AtmosphericTemperatureJsonNode(jsonNode);
	}
}
