package org.geogebra.common.euclidian;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.geogebra.common.kernel.MyPoint;
import org.junit.Test;

public class ClipAlgoSutherlandHodogmanTest {
	private final ClipAlgoSutherlandHodogman algo = new ClipAlgoSutherlandHodogman();
	private final ArrayList< MyPoint > input = new ArrayList<>();
	private ArrayList< MyPoint > output = new ArrayList<>();
	private static final double[][] defaultClipPolygon = {
			{0, 0},
			{0, 100},
			{100, 100},
			{100, 0},
	};

	@Test
	public void allInsideTest() {
		addInput(10, 10);
		addInput(80, 10);
		addInput(80, 80);
		output = input; // just to be clear;
		assertOutput();
	}

	private void assertOutput() {
		assertEquals(output.toString(), processAlgo().toString());
	}

	@Test
	public void allOutsideTest() {
		addInput(-50, -50);
		addInput(100, -50);
		addInput(150, 150);
		addInput(-50, 150);

		addOutput(100, 100);
		addOutput(0, 100);
		addOutput(0, 0);
		addOutput(100, 0);

		assertOutput();
	}

	@Test
	public void rectTest() {
		addInput(20, -50);
		addInput(80, -50);
		addInput(80, 150);
		addInput(20, 150);
		addOutput(20, 100);
		addOutput(20, 0);
		addOutput(80, 0);
		addOutput(80, 100);
		assertOutput();
	}

	@Test
	public void clipRectTop() {
		addInput(20, -50);
		addInput(80, -70);
		addInput(80, 50);
		addInput(20, 70);

		addOutput(20, 0);
		addOutput(80, 0);
		addOutput(80, 50);
		addOutput(20, 70);

		assertOutput();
	}

	@Test
	public void clipRectRight() {
		addInput(20, 20);
		addInput(150, 20);
		addInput(150, 80);
		addInput(20, 80);

		addOutput(20, 20);
		addOutput(100, 20);
		addOutput(100, 80);
		addOutput(20, 80);
		assertOutput();
	}

	@Test
	public void clipFunctionX11Inverse() {
		addInput(0.0, 8581.642209225422);
		addInput(1.0, 14271.852596885805);
		addInput(1.0, 14271.852596885792);
		addInput(2.0000000000000036, 24458.72141376594);
		addInput(2.0000000000000036, 24458.721413765914);
		addInput(3.0000000000000036, 43247.182260575624);
		addInput(3.0000000000000036, 43247.18226057559);
		addInput(4.0000000000000036, 79063.37378226692);
		addInput(4.0000000000000036, 79063.37378226683);
		addInput(5.0, 149898.03954623753);
		addInput(5.0, 149898.03954623739);
		addInput(6.0, 295890.6543481319);
		addInput(6.0, 295890.65434813156);
		addInput(7.0, 611138.9809115885);
		addInput(7.0, 611138.980911588);
		addInput(7.999999999999998, 1328955.0898624738);
		addInput(7.999999999999998, 1328955.0898624724);
		addInput(8.999999999999998, 3066125.025452564);
		addInput(8.999999999999998, 3066125.0254525607);
		addInput(9.999999999999998, 7578479.937482587);
		addInput(9.999999999999998, 7578479.937482581);
		addInput(10.999999999999996, 2.0316079416454073E7);
		addInput(10.999999999999996, 2.0316079416454047E7);
		addInput(11.999999999999996, 6.0022016278451785E7);
		addInput(11.999999999999996, 6.002201627845173E7);
		addInput(12.999999999999996, 1.996316748703127E8);
		addInput(12.999999999999996, 1.9963167487031248E8);
		addInput(13.999999999999996, 7.695619226451871E8);
		addInput(13.999999999999996, 7.695619226451864E8);
		addInput(14.999999999999996, 3.5836680244573784E9);
		addInput(14.999999999999996, 3.5836680244573746E9);
		addInput(15.999999999999996, 2.144231657643587E10);
		addInput(15.999999999999996, 2.1442316576435852E10);
		addInput(16.999999999999996, 1.8179851125358594E11);
		addInput(16.999999999999996, 1.8179851125358575E11);
		addInput(17.999999999999996, 2.587608759287599E12);
		addInput(17.999999999999996, 2.5876087592875967E12);
		addInput(18.999999999999996, 8.637002649214738E13);
		addInput(18.999999999999996, 8.637002649214728E13);
		addInput(19.999999999999996, 1.5359698663962568E16);
		addInput(19.999999999999996, 1.5359698663962552E16);
		addInput(20.999999999999996, 3.824445695766196E20);
		addInput(21.999999999999996, -1.6759572775214304E17);
		addInput(22.999999999999996, -6.31545539722499E23);
		addInput(22.999999999999996, -1.67595727752143232E17);
		addInput(23.999999999999996, -3.6101645203176E14);
		addInput(23.999999999999996, -3.6101645203176044E14);
		addInput(24.999999999999996, -7.182590185863269E12);
		addInput(24.999999999999996, -7.182590185863274E12);
		addInput(25.999999999999996, -4.02110644593568E11);
		addInput(25.999999999999996, -4.021106445935684E11);
		addInput(26.999999999999996, -4.104910599987946E10);
		addInput(26.999999999999996, -4.104910599987951E10);
		addInput(27.999999999999996, -6.207982828435241E9);
		addInput(27.999999999999996, -6.207982828435247E9);
		addInput(28.999999999999996, -1.2389080144212327E9);
		addInput(28.999999999999996, -1.2389080144212341E9);
		addInput(29.999999999999996, -3.038708841807266E8);
		addInput(29.999999999999996, -3.0387088418072695E8);
		addInput(31.0, -8.740934418567118E7);
		addInput(31.0, -8.740934418567125E7);
		addInput(31.999999999999996, -2.8545074378254086E7);
		addInput(31.999999999999996, -2.854507437825411E7);
		addInput(33.0, -1.0337447161671394E7);
		addInput(33.0, -1.0337447161671406E7);
		addInput(33.99999999999999, -4079399.7377219927);
		assertOutput();
	}

	private void addInput(double x, double y) {
		input.add(new MyPoint(x, y));
	}

	private ArrayList<MyPoint> processAlgo() {
		return algo.process(input, defaultClipPolygon);
	}

	private void addOutput(double x, double y) {
		output.add(new MyPoint(x, y));
	}
	
}
