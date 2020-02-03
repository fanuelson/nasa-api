package com.preoday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.preoday.service.NasaService;
import com.preoday.vo.TemperatureResponseVO;

@RestController
@RequestMapping("/nasa")
public class NasaController {

	@Autowired
	private NasaService nasaService;

	@GetMapping("/temperature")
	public ResponseEntity<?> findOne(@RequestParam(name = "SOL", required = false) Integer sol) {
		TemperatureResponseVO temperatureResponseVO = nasaService.getMarsTemperatureAverage(sol);
		return ResponseEntity.ok(temperatureResponseVO);
	}

}
