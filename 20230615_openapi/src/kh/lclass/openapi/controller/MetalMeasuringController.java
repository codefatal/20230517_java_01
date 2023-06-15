package kh.lclass.openapi.controller;

import kh.lclass.openapi.model.service.MetalMeasuringService;

public class MetalMeasuringController {
	public void getMeMeAll() {
		MetalMeasuringService service = new MetalMeasuringService();
		service.start();
	}
}