/*
* Demonstrate the 0(1), O(n), O(logn)
*/
class BigO
{
  private int[] givenArray;
  private int arraySize;
  private int itemsInArray = 0;
  static long startTime;
  static long endTime;
  
  public static void main(String[] paramArrayOfString) { 
    BigO localBigO1 = new BigO(10000);
    localBigO1.generateRandomArray();
    
    BigO localBigO2 = new BigO(20000);
    localBigO2.generateRandomArray();

    BigO localBigO3 = new BigO(300000);
    localBigO3.generateRandomArray();
   
    BigO localBigO4 = new BigO(400000);
    localBigO4.generateRandomArray();
   
    localBigO1.linerSearch(20);
    localBigO2.linerSearch(20);
    localBigO3.linerSearch(20);
    localBigO4.linerSearch(20);

    /* OUTPUT
     Item found :true
     Linear Search Took 4
     Item found :true
     Linear Search Took 4
     Item found :true
     Linear Search Took 5
     Item found :true
     Linear Search Took 24
   */
   localBigO1.bubbleSort();
   localBigO2.bubbleSort();
   


   /* OUTPUT
     Bubble Sort Took 233
     Bubble Sort Took 958
   */

   localBigO1.binarySearch(50);
   localBigO2.binarySearch(50);

  /* OUTPUT
    Element Found at: 437
    Time Throught the loop: 10
    Binary Search Took 0
    Element Found at: 858
    Time Throught the loop: 8
    Binary Search Took 0
  */
  }
  BigO(int paramInt) {
    arraySize = paramInt;
    givenArray = new int[paramInt];
  }
  
  //O(1) Insert an element in an Array
  public void addItemToArray(int paramInt) {
    givenArray[(itemsInArray++)] = paramInt;
  }
  
  // O(n) LinearSearch 
  public void linerSearch(int paramInt) {
    boolean found = false;
    String str = "";
    startTime = System.currentTimeMillis();
    for (int j = 0; j < arraySize; j++) {
      if (givenArray[j] == paramInt) {
        found = true;
        str = str + j + " ";
      }
    }
    System.out.println("Item found :" + found);
    endTime = System.currentTimeMillis();
    System.out.println("Linear Search Took " + (endTime - startTime));
  }
  // O(logn) Binary Search
  public void binarySearch(int value) { 
    startTime = System.currentTimeMillis();
    
    int startIndex = 0;
    int endIndex  = arraySize - 1;
    int timeThrough = 0;
    while(startIndex <= endIndex) {
     int middleIndex = ( startIndex + endIndex)/2;
     if (givenArray[middleIndex] < value) {
       startIndex = middleIndex +1;
      }
     else if (givenArray[middleIndex] > value) {
       endIndex = middleIndex -1;
     }
     else {
      System.out.println("Element Found at: "+ middleIndex);
      startIndex = endIndex +1;
     }
     timeThrough++;
    }
    
    System.out.println("Time Throught the loop: "+timeThrough);
    endTime = System.currentTimeMillis();
    System.out.println("Binary Search Took " + (endTime - startTime));
  }
  //O(n^2) Bubble Sort
  public void bubbleSort() {
    startTime = System.currentTimeMillis();
    for(int i = arraySize - 1; i > 0; i--) {
      for(int j = 0; j < i; j++) {
       if(givenArray[j] > givenArray[j+1]) {
         int temp = givenArray[j];
         givenArray[j] = givenArray[j+1];
         givenArray[j+1] = temp;
       }
      }
    }
    endTime = System.currentTimeMillis();
    System.out.println("Bubble Sort Took " + (endTime - startTime));
   
  }
  
  public void generateRandomArray()
  {
    for (int i = 0; i < arraySize; i++) {
      givenArray[i] = ((int)(Math.random() * 1000.0D) + 10);
    }
    itemsInArray = (arraySize - 1);
  }
}
