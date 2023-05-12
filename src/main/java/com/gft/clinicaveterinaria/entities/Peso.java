package com.gft.clinicaveterinaria.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Peso {
	@Column(name = "imperial_weight")
	private String imperial;
	@Column(name = "metric_weight")
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
