import java.text.DecimalFormat;

public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;
	private static final DecimalFormat DF = new DecimalFormat("0.00");

	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;

	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}

	public Triangle(double sideA, double sideB, double sideC) {
		if (isTriangle(sideA, sideB, sideC)) {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		} else {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}

	public Triangle(double[] sides) {
		if (isTriangle(sides)) {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
		} else {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}

	}

	public Triangle(Triangle triangle) {
		if (triangle != null) {
			sideA = triangle.getSideA();
			sideB = triangle.getSideB();
			sideC = triangle.getSideC();
		} else {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
	}

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public double[] getSides() {
		double[] sides = new double[3];
		sides[0] = sideA;
		sides[1] = sideB;
		sides[2] = sideC;
		return sides;

	}

	public double getAngleA() {
		return lawOfCosines(sideB, sideC, sideA);
	}

	public double getAngleB() {
		return lawOfCosines(sideA, sideC, sideB);
	}

	public double getAngleC() {
		return lawOfCosines(sideB, sideA, sideC);
	}

	public double[] getAngles() {
		double[] angles = new double[3];
		angles[0] = lawOfCosines(sideB, sideC, sideA);
		angles[1] = lawOfCosines(sideA, sideC, sideB);
		angles[2] = lawOfCosines(sideB, sideA, sideC);
		return angles;
	}

	public boolean setSideA(double sideA) {
		if (isTriangle(sideA, this.sideB, this.sideC)) {
			this.sideA = sideA;
			return true;
		} else
			return false;
	}

	public boolean setSideB(double sideB) {
		if (isTriangle(this.sideA, sideB, this.sideC)) {
			this.sideB = sideB;
			return true;
		} else
			return false;
	}

	public boolean setSideC(double sideC) {
		if (isTriangle(this.sideA, this.sideB, sideC)) {
			this.sideC = sideC;
			return true;
		} else
			return false;
	}

	public boolean setSides(double[] sides) {
		if (isTriangle(sides)) {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
			return true;
		} else
			return false;
	}

	public static boolean isTriangle(double a, double b, double c) {
		if (a > 0 && b > 0 && c > 0) {
			if (a + b > c && b + c > a && c + a > b) {
				return true;
			}
		}
		return false;
	}

	public static boolean isTriangle(double[] sides) {

		if (sides != null && sides.length == 3) {

			double a = sides[0];
			double b = sides[1];
			double c = sides[2];

			if (a > 0 && b > 0 && c > 0) {
				if (a + b > c && b + c > a && c + a > b) {
					return true;
				}
			}
		}

		return false;
	}

	public static double lawOfCosines(double a, double b, double c) {

		double aa = a * a;
		double bb = b * b;
		double cc = c * c;
		double bot = 2 * a * b;
		double top = aa + bb - cc;

		return Math.toDegrees(Math.acos(top / bot));
	}

	public String toString() {
		return POLYGONSHAPE + "(" + DF.format(sideA) + ", " + DF.format(sideB) + ", " + DF.format(sideC) + ")";
	}

}
