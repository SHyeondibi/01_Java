package DebugPractice.Car;

import java.io.Serializable;

public class Car implements Serializable, Comparable<Car>{
	private String VIN;
	private String modelName;
	private String color;
	private int mileage;
	
	public Car() {
		
	}
	
	public Car(String VIN, String modelName, String color, int mileage) {
		super();
		this.VIN = VIN;
		this.modelName = modelName;
		this.color = color;
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [VIN=" + VIN + ", modelName=" + modelName + ", color=" + color + ", mileage=" + mileage + "]";
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String VIN) {
		this.VIN = VIN;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public int compareTo(Car o) {
		
		return (this.mileage - o.mileage);
	}

	
	
}
