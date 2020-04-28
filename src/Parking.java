public class Parking extends Car{

	
	//  PROPERTIES
	private byte freePlaces;
	private Car place1A;
	private Car place1B;
	private Car place1C;
	private Car place2A;
	private Car place2B;
	private Car place2C;
	Car[][] parkingArr = {{place1A, place2A}, 
			      {place1B, place2B}, 
			      {place1C, place2C}};

    
	//  CONSTRUCTOR    
	Parking() {
		this.freePlaces = 6;
	}
    
    
/////////////////////////////  PARKING-BOT  /////////////////////////////
	public void parkCar(Car c, String place) {
    	
		place = place.toUpperCase();
		int placeI = numByLett(place);
		int placeJ = Character.getNumericValue(place.charAt(0)) - 1;

		if(checkingLicense(c)) 
			if (checkingPlace(placeI,placeJ))   			   			
				setCar(c, placeI, placeJ, place);
	}
    
	private int numByLett(String place) {
		switch(place.charAt(1)) {
			case 'A':
				return 0;
			case 'B':
				return 1;
			case 'C':
				return 2;
			default:
				return 3;
    	}
	}
    
	private boolean checkingPlace(int placeI, int placeJ) {

		if (0 <= placeJ && placeJ <= 1  && placeI != 3)
			return true;

		else			
			System.err.println("\nUnfortunately, we don't have such a place.\n"+
					   "Please use one from the range: [1A] ---> [2C]");
			return false;  		
	}
    
	private void setCar(Car c, int placeI, int placeJ, String place) {
    	
		if(parkingArr[placeI][placeJ] == null) { 
			parkingArr[placeI][placeJ] = c;
			printParking(c,place);
			freePlaces -= 1;	

		}else
			System.err.println("\nUnfortunately, this place is occupied!"+
					   "\nPlease use another one.");
	}
  
	private boolean checkingLicense(Car c) {
		if(c.getModel() != null)
			return true;
		
		else
			System.err.println("\nYour car is unlicensed!\n"+
					   "Please come back with a licensed one!");
			return false;
	}
	
    
///////////////////////////////  GETTERS  ///////////////////////////////
	public byte getFreePlaces() {
		return freePlaces;
	}
    
	public Car getCar(String place) {
    	
		place = place.toUpperCase();
		int placeI = numByLett(place);
		int placeJ = Character.getNumericValue(place.charAt(0)) - 1;
    	
		if (checkingPlace(placeI,placeJ)) {

			if (parkingArr[placeI][placeJ] != null) 
				return parkingArr[placeI][placeJ];

			else
				System.err.printf("%nTHE PLACE - %s - IS EMPTY!!!", place);
				return null;
		}
		else
			return null;
    		
    }
    

///////////////////////////  PRINT TEMPLATES  ///////////////////////////
   	public void printMap() {
   		
		System.out.println("\n\n---------------------------");
	
		for(int i = 0 ; i < parkingArr.length; i++) {
			printModel(parkingArr[i][0]);
			printModel(parkingArr[i][1]);
			System.out.println("|");
			printId(parkingArr[i][0]);
			printId(parkingArr[i][1]);
			System.out.println("|");
			System.out.print("---------------------------\n");
		}
    
   	}
    
    void printParking(Car c, String placeJ ) {
		System.out.printf("The %s with the ID [%s] is parked in the place [%s]%n", 
				   c.getModel(), c.getId(), placeJ);
    }

    
    //  PRINT PLACE INFO
	public void printInfoPlace(String place) {
		
		place = place.toUpperCase();
		Car c = getCar(place);
		
		if (c != null) 		
			System.out.printf("%nPlace %s ---> %s [%s]%n", 
					   place, c.getModel(), c.getId());   
	}
}
