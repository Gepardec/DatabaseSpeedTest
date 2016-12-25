package com.gepardec.speedtest.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Model
public class SpeedTestController {

	@Min(0)
	@Max(1000000)
	private Integer numRecords = 10;

	@Inject
	private NormalController normalController;
	
	@Inject
	private BatchsizeController batchsizeController; 
	
	public String all(){
		normalController.all();
		batchsizeController.all();
		return "index.xhtml";
	}
	
	public Integer getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(Integer numRecords) {
		this.numRecords = numRecords;
	}
	
	
}
