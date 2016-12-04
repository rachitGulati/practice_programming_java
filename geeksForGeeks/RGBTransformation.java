/*
Given an array of three colors. The array elements have a special property. Whenever two elements of different colors become adjacent to each other, they merge into an element of the third color
Question: How many minimum number of elements can be there in array after considering all possible transformations.

Example:

Input : arr[] = {R, G}
Output : 1
G B -> {G B} R -> R

Input : arr[] = {R, G, B}
Output : 2
Explanation : 
R G B -> [R G] B ->  B B
OR
R G B -> R {G B} ->  R R 

*****Possible Patterns*****

Let n be number of elements in array. No matter what the input is, we always end up in three types of outputs:

n: When no transformation can take place at all
2: When number of elements of each color are all odd or all even
1: When number of elements of each color are mix of odd and even
*/

class RGBTransformation {
	
	public static int transformation(char input[]) {
		int count_r, count_b, count_g;
		count_r = count_b = count_g = 0;
		for (int i = 0; i< input.length; i++) {
			switch (input[i]) {
				case 'R':
				case 'r': count_r++; break;
				case 'B':
				case 'b': count_b++; break;
				case 'G':
				case 'g': count_g++; break;
				default: return -1; 
			}
		}
		if (count_r == input.length || count_g == input.length || count_b == input.length) {
		//No transformation take place
			return input.length;
		}
		else if (((count_r%2 == 1) && (count_g%2 == 1) && (count_b%2 == 1)) || ((count_r%2 != 1) && (count_g%2 != 1) && (count_b != 1) ) ) {
		// When number of elements of each color are all odd or all even
			return 2;
		}
		else {
		//When number of elements of each color are mix of odd and even
			return 1;
		} 
	}

	public static void main(String args[]) {
		int elementLeftAfterTransformation = 0;
		if(args.length == 0) {
			System.out.println("Pass argument while executing the params. Ex: java RGBTransformationRGBR");
			return;
		}
		char input[] = args[0].toCharArray();
		if(input.length == 0) { 
			System.out.println("String can't be empty");
			return;
		}
		elementLeftAfterTransformation = transformation(input);
		if(elementLeftAfterTransformation == -1) {
			System.out.println("Input string is not valid");
			return;
		}
		System.out.println("Number of elemnets left: " + elementLeftAfterTransformation);
	}
}
