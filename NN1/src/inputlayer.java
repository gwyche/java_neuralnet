
//This class creates an input vector (array) of an arbitrary size 
public class inputlayer {
	
	//Input vector
	private double[] state;
	
	//Constructor generates an unpopulated array
	public inputlayer(double[] inputarray){
		this.state = inputarray;
	}
	
	//Getter for state vector
	public double[] getState() {
		return this.state;
	}

	//Setter for state vector
	public void setState(double[] state) {
		this.state = state;
	}

}
