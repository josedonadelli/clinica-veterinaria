package com.gft.clinicaveterinaria.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Altura {
	
	@Column(name = "imperial_height")
	private String imperial;
	@Column(name = "metric_height")
	private String metric;
	public String getImperial() {
		return imperial;
	}
	public void setImperial(String imperial) {
		this.imperial = imperial;
	}
	public String getMetric() {
		return metric;
	}
	public void setMetric(String metric) {
		this.metric = metric;
	}
	
	
}
