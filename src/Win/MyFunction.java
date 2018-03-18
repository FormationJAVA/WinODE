package Win;

import ODE.Function;

public class MyFunction implements Function{

	@Override
	public double f(double x) {

		return Math.pow(x, 3) + x -1;
	}

	@Override
	public double[] f(double[] x) {
		double l=1;
		double g=9.81;
		double k=2.0;
		double [] y = { x[1],
						-(g/l)*Math.sin(x[0])- (k*x[1])};
		return y;
	}

}
