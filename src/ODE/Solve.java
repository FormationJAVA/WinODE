package ODE;

public class Solve {
	/**
	 * Solve the equation F(x)=0 using the Bisection method 
	 * @param f the function F(x)
	 * @param a the lower bound of the [a,b]
	 * @param b the upper bound of the [a,b]
	 * @return x the root of F(x)=0
	 */
	public static double dichotomie (Function f,double a, double b)
	{
		double tol = 0.00000005;
		double m = 0;
		double dist = b-a;
		while (dist>tol)
		{
			m=(a+b)/2.0;
			if (f.f(a)*f.f(m)<=0)
				b=m;
			else 
				a=m;
			dist = b-a;
		}

		return m;
	}
	
	/**
	 * Solve the Dynamic System x' = F(x)  using the Euler Method
	 * @param F The set of differential equations defining the dynamic system
	 * @param x0 the initial state
	 * @param h the step
	 * @param T number of points computed 
	 * @return x(t) the solution of x'=F(x)
	 */
	public static double[][] Euler (Function F, double [] x0, double h, int T )
	{
		int dim = x0.length;
		double x[][] = new double [T][dim];
		x[0] = x0;
		double []tmp=new double [dim];

		for (int i = 1; i< T;i++)
		{
			tmp = F.f(x[i-1]);
			for (int j= 0; j<dim;j++)
			{	
				x[i][j] = x[i-1][j] + (h* (tmp[j]));
			}
		}
		return x;
	}

}
