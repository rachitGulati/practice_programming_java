/*
* Demonstrate the 0(1) Insert in an Array, 
* O(n) Linear Search in an Array,
* O(logn) Binary Search in an Array
* O(nlogn) Quick Sort in an Array
* O(n^2) Bubble sort in an Array
*/
class BigO
{
  private int[] givenArray;
  private int arraySize;
  private int itemsInArray = 0;
  static long startTime;
  static long endTime;
  
  public static void main(String[] paramArrayOfString) { 
    BigO localBigO1 = new BigO(1000);
    localBigO1.generateRandomArray();
    
    BigO localBigO2 = new BigO(2000);
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

   startTime = System.currentTimeMillis();
   localBigO1.quickSort(0, localBigO1.itemsInArray);
   endTime = System.currentTimeMillis();
   System.out.println("Quick Sort Took " + (endTime - startTime));
    
   startTime = System.currentTimeMillis();
   localBigO2.quickSort(0, localBigO2.itemsInArray);
   endTime = System.currentTimeMillis();
   System.out.println("Quick Sort Took " + (endTime - startTime));
  
  /*OUTPUT
   Quick Sort Took 11
   Quick Sort Took 26
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

  //O(nlogn) Quick Sort. It's not efficient algorithm since for large number of elements (100000) it will throw java.lang.StackOverflowError

  public void quickSort(int left, int right){
   if(right  - left <=0){
     return;
   }
   int pivot = givenArray[right];
   int pivotLocation  = partitionArray(left, right, pivot);
   quickSort(left, pivotLocation - 1);
   quickSort(pivotLocation + 1, right);
   
  }
  
  public int partitionArray(int left, int right, int pivot) {
   int leftP = left - 1; //Left Pointer of the array
   int rightP = right; // Right Pointer of the array
   while(true) { 
    while(givenArray[++leftP] < pivot);
    while(rightP > 0 && givenArray[--rightP] > pivot);
    
    if(leftP >= rightP) {
     break;
    }
    else {
     // Swaping the value;
     givenArray[leftP] = givenArray[leftP] + givenArray[rightP];
     givenArray[rightP] = givenArray[leftP]  - givenArray[rightP];
     givenArray[leftP] = givenArray[leftP] - givenArray[rightP];
    }
   }
   int temp = leftP;
   leftP = right;
   right = temp;

   return leftP;
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


/*
* I lost this program miskenly due to `rm` command. Then I recovered it from BigO.class file. So please don't mind the indendation and variable names;
*/
