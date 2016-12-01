/*
Reverse the string by replacing the characters on both side of the middle element
*/
public class ReverseString {
	public static void main(String inputArray[]){
		char input[] = inputArray[0].toCharArray();
		char characterToBeReplace;
		int length = input.length;
		for(int i=0; i <= length/2; i++) {
			characterToBeReplace = input[length - 1 - i];
			input[length -1 - i] = input[i];
			input[i] = characterToBeReplace;
		}
		System.out.println(new String(input));
	}
}
