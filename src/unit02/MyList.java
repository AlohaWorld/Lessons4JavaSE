package unit02;

public class MyList {

	public static void main(String[] args) {

		double[] myList1 = new double[10];
		
		/* What will happen if you try separating 
		 * the next statement into two steps? 
		 */
		double[] myList2 = {1.9, 2.9, 3.4, 3.5}; 
		/*
		double[] myList2;
        myList2 = {1.9, 2.9, 3.4, 3.5}; 
		*/
		System.out.println("length of myList2:" + myList2.length);
		
		//myList1.length = 8; // Can we change the array size?
		
		myList1[0] = 1.0;
		myList2[myList2.length-1] = 1.0;
		
		//myList1[10] = 1.0; // Exceed the array boundary?
	}
}
