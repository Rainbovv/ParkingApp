public class Application {

	public static void main(String[] args) {
		
		Parking p1 = new Parking();
		Car c1 = new Car("BMW", "AB-123");
		Car c2 = new Car("Fiat", "xy-567");
		p1.parkCar(c1, "1a");
		p1.parkCar(c2, "2c");
		p1.printMap();
	}
		
}
