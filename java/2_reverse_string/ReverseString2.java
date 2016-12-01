/*
Reverse the string by replacing the characters on both side of the middle element without extra variable
1) First store the difference of the two values at the small varibale location.
2) Subsctract the difference from the large value and it will become the small value
3) Add the small value in second step with difference at tha same location 

EX: 31 Values
		 32 difference of two at small value location 3 - 1 = 2
		 12 Now subtract large by difference 3 - 2 = 1
		 13 Add difference to new small value 1 + 2 = 3
*/
public class ReverseString2 {
	public static void main(String inputArray[]){
		if(inputArray.length == 0){
			System.out.println("Please enter some value in the argument while executing the method.\n Ex: java ReverseSting hello Result: olleh");
			return;
		}
		char input[] = inputArray[0].toCharArray();
		int length = input.length;
		//Case in which only one character is present ex: n
		if(length == 1){
			System.out.println(new String(input));
			return;
		}
		//Case in which only two characters are present ex: go
		if(length == 2){
			if( ((int)input[0]) > ((int) input[1])) {
				input[1] = (char) ((int) input[0] - (int) input[1]);
				input[0] = (char) ((int) input[0] - (int) input[1]);
				input[1] = (char) ((int) input[1] + (int) input[0]);
			}
			else {
				input[0] = (char)((int) input[1] - (int) input[0]);
				input[1] = (char) ((int) input[1] - (int)input[0]);
				input[0] = (char) ((int) input[1] + (int) input[0]);
			}
			System.out.println(new String(input));
			return;
		}
		/*Complexity O(n/2) ~ O(n)*/
		for(int i=0; i < length/2; i++) {
			if( ((int)input[i]) > ((int) input[length -i - 1])) {
				input[length - i - 1] = (char) ((int) input[i] - (int) input[length - i -1]);
				input[i] = (char) ((int) input[i] - (int) input[length -i -1]);
				input[length -i - 1] = (char) ((int) input[i] + (int) input[length - i -1 ]);
			}
			else {
				input[i] = (char) ((int) input[length -i - 1] - (int) input[i]);
				input[length - i - 1] = (char) ((int) input[length -i - 1] - (int) input[i]);
				input[i] = (char) ((int) input[length -i - 1] + (int) input[i]);
			}
		}
		System.out.println(new String(input));
	}
}
