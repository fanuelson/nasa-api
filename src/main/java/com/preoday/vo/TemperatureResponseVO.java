package com.preoday.vo;

public class TemperatureResponseVO {

	private Double averageTemperature;

	public TemperatureResponseVO() {
		super();
	}

	public TemperatureResponseVO(Double averageTemperature) {
		super();
		this.averageTemperature = averageTemperature;
	}

	public Double getAverageTemperature() {
		return averageTemperature;
	}

	public void setAverageTemperature(Double averageTemperature) {
		this.averageTemperature = averageTemperature;
	}

}
