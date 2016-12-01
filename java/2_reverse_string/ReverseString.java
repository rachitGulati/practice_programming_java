/*
Reverse the string by replacing the characters on both side of the middle element
*/
public class ReverseString {
	public static void main(String inputArray[]){
		if(inputArray.length == 0){
			System.out.println("Please enter some value in the argument while executing the method.\n Ex: java ReverseSting hello Result: olleh");
			return;
		}
		char input[] = inputArray[0].toCharArray();
		char tempCharacter;
		int length = input.length;
		//Case in which only one character is present ex: n
		if(length == 1){
			System.out.println(new String(input));
			return;
		}
		//Case in which only two characters are present ex: go
		if(length == 2){
			tempCharacter = input[0];
			input[0] = input[1];
			input[1] = tempCharacter;
			System.out.println(new String(input));
			return;
		}
		/*Complexity O(n/2) ~ O(n)*/
		for(int i=0; i < length/2; i++) {
			tempCharacter = input[length - 1 - i];
			input[length -1 - i] = input[i];
			input[i] = tempCharacter;
		}
		System.out.println(new String(input));
	}
}
