package DebugPractice.Car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CarManagerImpl implements ICarManager{
	private List<Car> carList = new ArrayList<>();
	
	private static ICarManager instance = new CarManagerImpl();
	
	private CarManagerImpl() {
		
	}
	
	public static ICarManager getInstance() {
		return instance;
	}

	@Override
	public void add(Car car) {
		carList.add(car);
	}

	@Override
	public Car[] getList() {
		Car[] result = new Car[carList.size()];
		
		for(int i = 0; i < carList.size();i++) {
			result[i] = carList.get(i);
		}
		return result;
	}

	@Override
	public Car[] searchByModelName(String modelName) throws ModelNameNotFoundException {
		List<Car> tempList = new ArrayList<>();
		
		for(Car c : carList) {
			if(c.getModelName().contains(modelName)){
				tempList.add(c);
			}
		}
		
		if(tempList.size() == 0) {
			throw new ModelNameNotFoundException(modelName);
		}
		
		Car[] result = new Car[tempList.size()];
		
		for(int i = 0; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}
		
		return result;
	}

	@Override
	public ElectricCar[] getElectricCars() {
		List<ElectricCar> tempList = new ArrayList<>();
		
		for(Car c : carList) {
			if(c instanceof ElectricCar) {
				tempList.add((ElectricCar)c);
			}
		}
		
		ElectricCar[] result = new ElectricCar[tempList.size()];
		
		for(int i = 0 ; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}

		return result;
	}

	@Override
	public int getTotalMileage() {
		int sum = 0;
		
		for(Car c : carList) {
			sum += c.getMileage();
		}
		
		return sum;
	}

	@Override
	public void loadData() {
		File file = new File("car.dat");
		if(file.exists()) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
				carList = (List<Car>) ois.readObject();
			}catch(Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void saveData() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.dat"))){
			oos.writeObject(carList);
		}catch(Exception e) {
			System.out.println("파일 저장에 실");
			e.printStackTrace();
		}
		
	}


	
	


}
