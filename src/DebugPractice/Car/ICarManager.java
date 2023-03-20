package DebugPractice.Car;

public interface ICarManager {
	void add(Car car);
	
	Car[] getList();
	
	Car[] searchByModelName(String modelName) throws ModelNameNotFoundException;
	
	ElectricCar[] getElectricCars();
	
	int getTotalMileage();
	
	void loadData();

	void saveData();
}
