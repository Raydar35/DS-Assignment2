/**
 * @author: Fahmida Hamid
 * @author: your-name-goes-here
 * @date: 10/02/2024
 * @version: 1.0
 * 
 * This concrete class has several definitions of a method: generateHashCode.
 * The method takes a string and some other parameters and produces a 
 * corresponding Integer object that may be used as a hash key.
 *  
 */
package hashing;

public class HashCodeGenerator{
	
	/**
	 * It computes a hash code for a given string by adding the 
	 * ASCII values of each character from the string
	 * @param x, a String
	 * @return code, an Integer
	 */
	public static Integer generateHashCode(String x) {
		
		Integer code = 0;
		char[] input = x.toCharArray();
		
		for(char c: input) {
		 	code += (int) c;
		}
	  return code;	
	}
	
	/**
	 * It computes the hash code for a given string by adding the ASCII values 
	 * of each character from the string, multiplied by a positive bias.
	 * @param x, a String and bias, an integer <consider only positive values>
	 * @return code, an Integer
	 */
	public static Integer generateHashCode(String x, int bias) {
		
		Integer code = 0;
		char[] input = x.toCharArray();
		
		for(char c: input) {
		 	code = code + (int) c * bias;
		}
	  return code;	
	}
    
	/**
	 * It computes the hash code for a given string by adding the ASCII values 
	 * of each character from the string, multiplied by a positive bias, up to a maximum
	 * length.
	 * @param x, a String
	 * @param bias, an integer <consider only positive values>
	 * @param uptoZ, a positive integer, usually be less than the length of x
	 * @return code, an Integer
	 */
    public static Integer generateHashCode(String x, int bias, int uptoZ) {
		
		Integer code = 0;
		char[] input = x.toCharArray();
		
		int i = 0;
		for(char c: input) {
		 	code = code * bias + (int) c;
		 	i++;
		 	if(uptoZ < i) break;
		}
	  return code;	
	}
	
    /**
     * [5 points] To-Do: Add another overloaded version of the 
     * generateHashCode method. You may take any types of 
     * data as input but you must return an Integer
     * @param args
     * {@return Integer}
     */

	/**
	 * Generates a hash code for the given array of integers.
	 * Adds the integer, multiplied by the bias.
	 * @param arr
	 * @param bias
	 * @return
	 */
	public static Integer generateHashCode(int[] arr, int bias) {
		Integer code = 0;
		for (int value : arr) {
			code = code * bias + value;
		}
		return code;
	}
	
	public static void main(String[] args) {
		
		String[] initialData = {"John", "Jerry", "Mike", "Abby", "Tina", "Fahmida", "CatWoman"};

		
		System.out.println("\n >> Working with the simplest version (ASCII code) >>");
		
		for(String s: initialData) {
			
			System.out.println("input = " + s + 
					", hash code = " + HashCodeGenerator.generateHashCode(s));
		}
		
		System.out.println("\n >> Working with Bias 2: >>");
		
		for(String s: initialData) {
			
			System.out.println("input = " + s + 
					", hash code = " + HashCodeGenerator.generateHashCode(s, 2));
		}
		
		System.out.println("\n >> Working with Bias 10: >> ");
		
		for(String s: initialData) {
			
			System.out.println("input = " + s + 
					", hash code = " + HashCodeGenerator.generateHashCode(s, 10));
		}
		
		System.out.println("\n >> Working with Bias 3, length 5 (max): >>");
         for(String s: initialData) {
			
			System.out.println("input = " + s + 
					", hash code = " + HashCodeGenerator.generateHashCode(s, 3, 5));
		}

		int[][] arrayNumbers = {
				{1,2,3},
				{3,5,6},
				{10,20,30,40},
				{51},
				{34,53,153}
		};
		System.out.println("\n >> int[] version working with Bias 7: >>");
		for (int[] arr : arrayNumbers) {
			Integer hash = generateHashCode(arr, 7);
			System.out.print("input = {");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
				if (i < arr.length - 1) System.out.print(",");
			}
			System.out.println("}, hash code = " + hash);
		}
	}

}
