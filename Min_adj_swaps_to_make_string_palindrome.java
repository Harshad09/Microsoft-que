Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
  
  
rithiksingh098's avatar
rithiksingh098
266
Last Edit: February 6, 2021 4:11 AM

62.2K VIEWS

Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.

Example 1:

Input: "mamad"
Output: 3
Example 2:

Input: "asflkj"
Output: -1
Example 3:

Input: "aabb"
Output: 2
Example 4:

Input: "ntiin"
Output: 1
Explanation: swap 't' with 'i' => "nitin"
  
  
  
  /**
     * Algorithm:
     *     1. First check the given string is a jumbled/shuffled palindrome or not.
     *     2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start iterating.
     *     3. If chars at both the pointers are same then just shrink the window (increase the p1 and decrease the p2).
     *     4. or Else
     *          a. find the matching pair and swap the char to p2 index (increase swap count while swapping) and finally shrink the window.
     *          b. if not found just swap once with adjacent index and increase the swap count (do not shrink the window here)
     *     5. Print the Swap Count
     *
     * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration * O(n) for checking and swapping ] so => O(n^2)
     * Space Complexity: O(n)
     *
     */
  
  
  
  
  import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        String s = "ntiin";
        int n = s.length();
        int swapCount =0;
        if(!isValidPalindrome(s)) System.out.println("Not a Palindrome");
        
        int i=0,j=n-1;
        char[] c = s.toCharArray();
        while(i<j) {
            
            if(c[i] != c[j]) {
                int k = j;
                while(c[i] != c[k]) k--;
                
                if(i == k) {
                    c = swap(c,i,k);
                    swapCount++;
                }else {
                    while(k<j) {
                        c = swap(c,k,k+1);
                        swapCount++;
                        k++;
                    }
                    
                }
                
            }
            
            i++;j--;
            
        }
        
        System.out.println(swapCount);
        
     }
     
     public static char[] swap(char[] c, int i, int j) {
         char temp = c[i];
         c[i] = c[j];
         c[j] = temp;
         
         return c;
     }
     
     public static boolean isValidPalindrome(String s) {
         int[] check = new int[26];
         
         for(int i= 0;i<s.length();i++) {
             check[s.charAt(i) - 'a']++;
         }
         int odd = 0;
         for(int i=0;i<26;i++) {
             if(check[i] % 2 == 1) {
                 odd++;
             }
         }
         
         if(odd >1) return false;
         return true;
     }
}
