# String Anagrams (hard) #
Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
```
abc
acb
bac
bca
cab
cba
```
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:
```
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
```
Example 2:
```
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
```
## Solution
This problem follows the Sliding Window pattern and is very similar to Permutation in a String. In this problem, we need to find every occurrence of any permutation of the pattern in the string. We will use a list to store the starting indices of the anagrams of the pattern in the string.

## Code
Here is what our algorithm will look like, only the highlighted lines have changed from Permutation in a String:

```
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start = 0;
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        int matched = 0;
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            charFrequency.put(c, charFrequency.getOrDefault(c, 0)+1);
        }

        
        for(int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            if(charFrequency.containsKey(rightChar)) {
                charFrequency.put(rightChar, charFrequency.get(rightChar) -1);
                if( charFrequency.get(rightChar) == 0) {
                    matched++;
                }
            }
            
            if(matched == charFrequency.size()) {
                result.add(start);
            }
            
            if(i >= p.length()-1) {
                char leftChar = s.charAt(start);
                start++;
                if(charFrequency.containsKey(leftChar)) {
                   if( charFrequency.get(leftChar) == 0) {
                        matched--;
                    }
                     charFrequency.put(leftChar, charFrequency.get(leftChar) +1);

                }
            }
            
        }
        return result;
    }
}
```