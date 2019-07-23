
public class articlesfortesting {

	public static void main(String[] args) {

		System.out.println(Math.tanh(.5));
		System.out.println(Math.random() - .5);
		
		double[] inputarray = {1,2,1,2,1,0,0,0,0,0};
		System.out.println(inputarray[1]);
		
		weights w_matrix1 = new weights(5,5);
		System.out.println(w_matrix1.getWeightmatrix()[1][2]);

	}

}
