package ODE;
/**
 * Interface to define functions
 * @author Bilal BOUALEM
 *
 */
public interface Function {
	/**
	 * Function used to solve F(x) =0
	 * @param x the variable of the function F(x)=0 
	 * @return F(x)
	 */
	public double f(double x);
	/**
	 * F(x) is a System of dynamic equations. 
	 * @param x is the state of the dynamic system 
	 * @return the state of the Dynamic System
	 */
	public double[] f (double[] x);

}
