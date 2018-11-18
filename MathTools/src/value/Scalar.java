package value;

public class Scalar extends Quantity {
	
	private double value;

	public Scalar(String unit) {
		super(0, unit);
		// TODO Auto-generated constructor stub
	}

	public Scalar(String unit, double value) {
		super(0, unit);
		this.value = value;
	}

	public double magnitude() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	

}
