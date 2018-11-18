package value;

public abstract class Quantity {
	
	private int dimension;
	private String unit;

	public Quantity(int dimension, String unit) {
		super();
		this.dimension = dimension;
		this.unit = unit;
	}
	
	public String unit() {
		return unit;
	}

	public abstract double magnitude();

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
