Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
  
  -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  With using extra space
  
  class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = split.length -1;i>=0;i--) {
            if(split[i].length()!=0) {
                sb.append(split[i]);
                if(i>0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
  without using extra space
  
  class Solution {
    public String reverseWords(String s) {
        String res = "";
        String temp = "";
        s = s.trim();
        System.out.println(s.length());
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) != ' ') {
                temp+= s.charAt(i);
            }else if(s.charAt(i) == ' ') {

                temp = new StringBuilder(temp).reverse().toString();
                res += temp+" ";
                temp = "";
                while(s.charAt(i-1) == ' ')i--;
            }
        }
        res += new StringBuilder(temp).reverse().toString();
        
        return res;
    }
}
