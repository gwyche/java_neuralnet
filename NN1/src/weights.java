import java.math.*;

public class weights {
	
	//private rank 2 matrix
	private double[][] weightmatrix;
	
	
	//weights object constructor
	//m = height, n = width
	weights(int m, int n){
		
		//Create temp matrix
		double[][] tempmatrix = new double[m][n];
		
		//Populate matrix with random numbers 
		for(int xindex = 0; xindex < n; xindex++) {
			for(int yindex = 0; yindex < m; yindex++) {
				//assign random number to each element
				tempmatrix[xindex][yindex] = (Math.random() - .5);
			}	
		}
		//transfer matrix elements inside constructor to private rank 2 matrix
		this.weightmatrix = tempmatrix;
	}

	//Getter for rank 2 tensor
	public double[][] getWeightmatrix() {
		return this.weightmatrix;
	}

	//Setter for rank 2 tensor
	public void setWeightmatrix(double[][] inputweightmatrix) {
		this.weightmatrix = inputweightmatrix;
	}
}
