package operation;

import java.util.ArrayList;
import java.util.List;

import value.DimensionUnmatchedException;
import value.Quantity;
import value.Scalar;
import value.Vector;

public class Operation {
	
	public static Quantity sum(Quantity q1, Quantity q2) throws UnitUnmatchedException, DimensionUnmatchedException {
		int d1 = q1.getDimension();
		String u1 = q1.unit();
		int d2 = q2.getDimension();
		String u2 = q2.unit();
		if (u1 != u2) {
			throw new UnitUnmatchedException();
		} else {
			if (d1 == 0 && d2 == 0) { //both are scalar
				return new Scalar(u1, q1.magnitude() + q2.magnitude());
			} else if (d1 > 0 && d1 == d2) { //both are vector
				List<Double> result = new ArrayList<Double>();
				for (int i = 1; i <= d1; i++) {
					result.set(i, ((Vector) q1).getCoordinate(i) + ((Vector) q2).getCoordinate(i));
				}
				return new Vector(d1, u1, result);
			} else { 
				throw new DimensionUnmatchedException();
			}
				
		}
		
	}
	
	public static Quantity difference(Quantity q1, Quantity q2) throws UnitUnmatchedException, DimensionUnmatchedException {
		return sum(q1, changeSign(q2));
	}
	
	public static Quantity product(Quantity q1, Quantity q2) {
		return null;
	}
	
	public static Quantity dotProduct(Quantity q1, Quantity q2) {
		return null;
	}
	
	private static void checkDimension (Quantity q1, Quantity q2) throws DimensionUnmatchedException {
		int d1 = q1.getDimension();
		int d2 = q2.getDimension();
		if (d1 > 0 && d2 > 0 && d1 != d2) {
			throw new DimensionUnmatchedException();
		}
	}
	
	public static Quantity changeSign(Quantity q) throws DimensionUnmatchedException {
		int d = q.getDimension();
		String u = q.unit();
		if (d == 0) {
			return new Scalar(u, q.magnitude() * (-1));
		} else {
			List<Double> result = new ArrayList<Double>();
			for (int i = 1; i <= d; i++) {
				result.set(i, ((Vector) q).getCoordinate(i) * (-1));
			}
			return new Vector(d, u, result);
		}
	}
	

}
