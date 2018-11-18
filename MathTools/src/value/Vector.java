package value;

import java.util.List;


/**
 * |r = x1 * |e1 + x2 * |e2 + x3 * |e3 + ...
 * @author Chester
 *
 */
public class Vector extends Quantity {
	
	private List<Double> coordinates;
	
	public Vector(int dimension, String unit) {
		super(dimension, unit);
		// TODO Auto-generated constructor stub
	}

	public Vector(int dimension, String unit, List<Double> coordinates) throws DimensionUnmatchedException {
		super(dimension, unit);
		this.coordinates = coordinates;
		this.checkDimension();
	}

	private void checkDimension() throws DimensionUnmatchedException {
		if (this.coordinates.size() != this.getDimension()) {
			throw new DimensionUnmatchedException();
		}
	}

	public double magnitude() {
		double result = 0.0;
		for (double c: this.coordinates) {
			result = result + (c * c);
		}
		return Math.sqrt(result);
	}

	public List<Double> getCoordinates() {
		return this.coordinates;
	}

	public void setCoordinates(List<Double> coordinates) throws DimensionUnmatchedException {
		this.coordinates = coordinates;
		this.checkDimension();
	}
	
	public double getCoordinate(int n) {
		return this.coordinates.get(n-1);
	}
	
	public void setCoordinate(int n, double x) {
		this.coordinates.set(n-1, x);
	}
	
	
	
	
	

}
