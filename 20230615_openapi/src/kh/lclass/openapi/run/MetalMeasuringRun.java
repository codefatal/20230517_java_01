package kh.lclass.openapi.run;

import kh.lclass.openapi.controller.MetalMeasuringController;

public class MetalMeasuringRun {
	public static void main(String[] args) {
		MetalMeasuringController meMeCtrl = new MetalMeasuringController();
		meMeCtrl.getMeMeAll();
	}
}