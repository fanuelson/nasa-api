package com.preoday.apirequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.preoday.jsonnodewrapper.InsightWeatherJsonNode;

@Service()
public class NasaApiRequester {

		private static final Logger logger = LoggerFactory.getLogger(NasaApiRequester.class);

		@Value("${api_base_urls.nasa}")
		private String nasaApiBaseUrl;
		
		@Value("${api_keys.nasa}")
		private String nasaApiKey;
		
		@Autowired
		private RestTemplate restTemplate;
		
		private String mountUrl(String resource) {
			return String.format("%s%s?api_key=%s&feedtype=json&ver=1.0", nasaApiBaseUrl, resource, nasaApiKey);
		}
		
		public InsightWeatherJsonNode requestMarsWeather() {
			try {
				JsonNode response = restTemplate.getForObject(this.mountUrl("/insight_weather/"), JsonNode.class); 
				return new InsightWeatherJsonNode(response);
			} catch(Exception e) {
				logger.error("Request mars weather error", e);
				throw e;
			}
		}
}
