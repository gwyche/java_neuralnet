import java.math.*;

public class MLP {

	public static void main(String[] args) {
		
		
		
		
		int count = 0;
		int goal = 500;
		double learnrate = .02;
		double bias = .0005;
		
		
		//Create an inputarray
		double[] inputarray = {1,2,1,2,1,0,0,0,5,0,0,0,5,2,3,1};  //INPUTS
		
		//Create target array of same length as input array with all zeroes
		double[] targetarray = new double[inputarray.length];

		//Decide which element of target should be hot
		int hotelement = 3; //TARGET SELECTION
		targetarray[hotelement] = .9;
		
		/*Assign inputarray dimension to a variable that will be used to create a matrix with sides
		that are the same length as the input array */
		int matrixwidth = inputarray.length;
		
		//Create a square rank 2 tensor with sides of the same length as the input array
		weights w_matrix1 = new weights(matrixwidth,matrixwidth);
		
		//Create a neuron layer
		neuronlayer neuronsL1 = new neuronlayer(matrixwidth);
		
		do {
		
		//Calculate neuron outputs
		double output1[] = neuronsL1.updateandreturnstate(inputarray, w_matrix1.getWeightmatrix());

		//Create an array to store activated outputs
		double activation1[] = new double[output1.length];

		for(int i = 0;i < output1.length;i++) {
			activation1[i] = (Math.tanh(output1[i])) + bias;
		}
		
		//Print out layer1 activation function outputs
		for(int i = 0;i < activation1.length;i++) {
		//System.out.print(activation1[i]);
		}
		//System.out.println("");
		
		//Declare and initiate error variables
		double squarederror = 0;
		double MSE = 0;
		
		//Calculate squared error
		for(int i = 0;i < activation1.length;i++) {
		squarederror = squarederror + .5 * Math.pow((activation1[i] - targetarray[i]), 2);
		}
		
		/////////////////// Backpropagation/////////////////////////
		//Calculate Mean Squared Error and output
		MSE = squarederror / activation1.length;
		System.out.println("Mean Squared Error: "+MSE);
		
		//Declare deltaerror array
		double deltaerror[] = new double[activation1.length];
		
		//Calculate error deltas
		for(int i = 0; i< activation1.length;i++) {
			deltaerror[i] = activation1[i] - targetarray[i];
		}
		
		//Declare delta_activation array
		double delta_activation[] = new double[activation1.length];
		
		//Calculate activation deltas
		for(int i = 0;i < activation1.length;i++) {
			delta_activation[i] = 2 / Math.cosh(2 * activation1[i] + 1);
		}
		
		//Declare correction array
		double correctionarray[] = new double[activation1.length];
		
		//Calculate correction array (values directly with respect to output elements)
		for(int i = 0; i < activation1.length; i++) {
			correctionarray[i] = delta_activation[i] * deltaerror[i] * learnrate;
		}
		
		//Declare weight correction tensor
		weights newweights = new weights(matrixwidth,matrixwidth);
		
		
		//Create two zeroed rank 2 tensors
		double blankmatrix1[][] = new double[matrixwidth][matrixwidth];
		double blankmatrix2[][] = new double[matrixwidth][matrixwidth];
		
		//Calculute weight correction tensor
		for(int i = 0; i< activation1.length;i++) {
			for(int j = 0; j < activation1.length;j++) {
				blankmatrix1[j][i] = correctionarray[i] * inputarray[j];
			}
		}
		
		//Generate Corrected Tensor
		for(int i = 0; i< activation1.length;i++) {
			for(int j = 0; j < activation1.length;j++) {
				blankmatrix2[j][i] = w_matrix1.getWeightmatrix()[j][i] - blankmatrix1[j][i];
			}
		}
		
		//Update weight tensor and add Tensor to original weights object
		w_matrix1.setWeightmatrix(blankmatrix2);
		
		count++;
		
		}while(count < goal);
		
	}

}
