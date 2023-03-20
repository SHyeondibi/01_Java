package DebugPractice.Car;

public class ModelNameNotFoundException extends Exception{
	private String modelName;
	
	Car car = new Car();
	
	public ModelNameNotFoundException(String modelName) {
		super(modelName + "모델명을 포함하는 자동차가 존재하지 않습니다.");
		this.modelName = modelName;
	}
	
	public String getTitle(String modelName) {
		return this.modelName;
	}
}
