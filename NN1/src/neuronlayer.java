
//This class creates an input vector (array) of an arbitrary size 
public class neuronlayer {
	
	//Input vector
	private double[] state;
	
	//Constructor generates an unpopulated array
	public neuronlayer(int width){
		double[] temp = new double[width];
		
		//Zero all array values
		for(int i = 0; i < width; i++) {
			temp[i] = 0;
		}
		
		this.state = temp;
	}
	
	//Getter for state vector
	public double[] getState() {
		return this.state;
	}

	//Setter for state vector
	public void setState(double[] state) {
		this.state = state;
	}
	
	//Update neuron output values
	public void updatestate(double[] previouslayerstate, double interveningweights[][]) {
		int previouslayerwidth = previouslayerstate.length;
		int weightmatrixwidth = interveningweights[0].length;
		double[] tempstate = new double[previouslayerwidth];
		
		for(int i = 0;i < weightmatrixwidth; i++) {
			for(int j = 0; j < previouslayerwidth; j++) {
				tempstate[i] = tempstate[i] + previouslayerstate[j] * interveningweights[j][i];
			}
			this.state = tempstate;
		}
	}
	
	//Update and return neuron output values
	public double[] updateandreturnstate(double[] previouslayerstate, double interveningweights[][]){
		int previouslayerwidth = previouslayerstate.length;
		int weightmatrixwidth = interveningweights[0].length;
		double[] tempstate = new double[previouslayerwidth];
		
		for(int i = 0;i < weightmatrixwidth; i++) {
			for(int j = 0; j < previouslayerwidth; j++) {
				tempstate[i] = tempstate[i] + previouslayerstate[j] * interveningweights[j][i];
			}
			this.state = tempstate;
		}
		
		return this.state;
	}
}
