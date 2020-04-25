
public class Car {
	
	//  PROPERTIES
	private String model;
	private String id;
	
	
	//  CONSTRUCTOR
	Car () {
	}
	
	Car (String model, String id) {
		setModel(model);
		if (this.model == null)
			return;
		else	
			setId(id);
		
	}
	
	
////////////////////  PRINT CAR INFO - templates  /////////////////////	
	void printModel() {
    	System.out.printf(getModel());
    	}
	
	public void printModel(Car c) {
    		if(c != null) 
    			System.out.printf("| %-10s ", c.getModel());
		else
    			System.out.printf("| %-10.0f ", 0f);  	
    	}
	 
	public void printId() {
    		System.out.print(getId());
	}
	
    	void printId(Car c) {
		if(c != null) 
			System.out.printf("| %-10s ", c.getId());
		else
			System.out.printf("| %-10.0f ", 0f);  	
	}

    
//////////////////////////////  SETTERS  //////////////////////////////
	public void setModel(String model) {
		
		if(model.equals("BMW") || model.equals("Mercedes") || model.equals("Fiat")) 
			this.model = model;

		else
			System.err.println("THERE IS NO SUCH A MODEL!!!\n"+
					   "Please enter one of this models:\n"+
					   "BMW, Mercedes, Fiat!");
		
	}

	public void setId(String id) {
		this.id = id.toUpperCase();
	}

	
/////////////////////////////  GETTERS  ////////////////////////////
	public String getId() {
		return id;
	}

	public String getModel() {
		return model;
	}	
}
