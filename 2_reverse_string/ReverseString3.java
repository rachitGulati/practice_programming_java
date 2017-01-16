/*
Reverse the string by recursion
Complexity of this algorith will be O(n)
T(n) = a + T(n - 1)
T(n) = a + a + T(n - 2)
...
...
T(n) = n * a + T(0) = n * a + b = O(n)

*/
public class ReverseString3 {
	public static String stringReverse(String inputString){
		int length = inputString.length();
		if(length == 1){
			return inputString;
		}
		return inputString.substring(length-1, length) + stringReverse(inputString.substring(0, length -1));
	}
	public static void main(String inputArray[]) {
		if(inputArray.length == 0){
			System.out.println("Please enter some value in the argument while executing the method.\n Ex: java ReverseSting hello Result: olleh");
			return;
		}
		String input = new String(inputArray[0]);
		input = stringReverse(input);
		System.out.println(input);
}
}
