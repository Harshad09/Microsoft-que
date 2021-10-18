Write a function that, given an array A of N integers, returns the lagest integer K > 0 such that both values K and -K exist in array A. If there is no such integer, 
the function should return 0.
  
  Example 1:

Input: [3, 2, -2, 5, -3]
Output: 3
Example 2:

Input: [1, 2, 3, -4]
Output: 0
 
 1.
Sorting + Two Pointers O(nlogn)
Array: [3,2,-2,5,-3]
After Sorting:[-3,-2,2,3,5]
Keep two pointers on the 0th and the last position respectively,
while(left<right) // To avoid zero's case
1)if the absolute values match, return the value
2) right--, if right's absolute value is greater than left's value
3)left++, if left's absolute value is greater than right's value

2.
Extra Space O(n)
Use an Array/HashMap to keep the occurences of the element, save the absolute value in the array/hashmap. whenever you already have your 
absolute value in the map, compare it with the ans variable and take the maximum out of the two.
  
  Using 1. approach ->
  
  import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        int[] arr = new int[]{3, 2, -2, 5, -3};
        
        System.out.println(largestNum(arr));
        
     }

     public static int largestNum(int[] arr) {
         
         Arrays.sort(arr);
         int i=0,j=arr.length-1;
        
        while(i<j) {
            if(-arr[i] == arr[j]) {
                return arr[j];
            }
            
            else if(-arr[i] < arr[j]) {
                j--;
            }
            else{
                i++;
            }
        }
        return 0;
     }
}


using 2. approach ->
  
   public static void main(String[] s){
        int[] arr = {-41,3,2,5,41};
        System.out.println(largestNumWithNegPair(arr));
 }
 private static int largestNumWithNegPair(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int curMax = 0;
        for (int a:arr) {
            // if the negated counter part is already existing, consider the number for largestNum selection.
            if(set.contains(a*-1))
                curMax = Math.max(curMax,Math.abs(a));
            else
                //keep track of the numbers read so far.
                set.add(a);
        }
 return curMax;
 }
