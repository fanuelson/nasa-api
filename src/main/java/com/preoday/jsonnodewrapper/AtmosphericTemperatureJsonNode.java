package com.preoday.jsonnodewrapper;

import com.fasterxml.jackson.databind.JsonNode;

public class AtmosphericTemperatureJsonNode {

	private static final String AV_FIELD = "av";
	
	private JsonNode jsonNode;
	
	public AtmosphericTemperatureJsonNode(JsonNode jsonNode) {
		this.jsonNode = jsonNode;
	}
	
	public Double getAverageTemperature() {
		return jsonNode.get(AV_FIELD).asDouble();
	}
}
