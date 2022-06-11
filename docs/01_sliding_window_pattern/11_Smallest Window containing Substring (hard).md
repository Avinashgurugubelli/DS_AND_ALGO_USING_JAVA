# Smallest Window containing Substring (hard) #
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

Example 1:
```
Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"
```
Example 2:
```
Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".
```
Example 3:

```
Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
```

## Solution
- This problem follows the Sliding Window pattern and has a lot of similarities with Permutation in a String with one difference. In this problem, we need to find a substring having all characters of the pattern which means that the required substring can have some additional characters and doesn’t need to be a permutation of the pattern. Here is how we will manage these differences:

- We will keep a running count of every matching instance of a character.
- Whenever we have matched all the characters, we will try to shrink the window from the beginning, keeping track of the smallest substring that has all the matching characters.
- We will stop the shrinking process as soon as we remove a matched character from the sliding window. One thing to note here is that we could have redundant matching characters, e.g., we might have two ‘a’ in the sliding window when we only need one ‘a’. In that case, when we encounter the first ‘a’, we will simply shrink the window without decrementing the matched count. We will decrement the matched count when the second ‘a’ goes out of the window.

## Code #
Here is how our algorithm will look; only the highlighted lines have changed from Permutation in a String:

```
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> targetCharMap = new HashMap<Character, Integer>();
        Map<Character, Integer> matchedCharMap = new HashMap<Character, Integer>();
        int left = 0;
        int matched = 0;
        int resultLen = Integer.MAX_VALUE;
        int windowStart = -1;
        int windowEnd = -1;
        for(int i=0; i< t.length(); i++) {
            char c = t.charAt(i);
            targetCharMap.put(c, targetCharMap.getOrDefault(c, 0) +1);
        }
        
        for(int right = 0; right< s.length(); right++) {
            char rightChar = s.charAt(right);
            if(targetCharMap.containsKey(rightChar)) {
                matchedCharMap.put(rightChar, matchedCharMap.getOrDefault(rightChar, 0)+1);
                if(matchedCharMap.get(rightChar) <= targetCharMap.get(rightChar)) {
                    matched++;
                }
            }

            // Shrink the window             
            while(matched == t.length()) {
                char leftChar = s.charAt(left);
                int prevResultLen = resultLen;
                resultLen = Math.min(resultLen, right - left +1);
                if(resultLen < prevResultLen) {
                   windowStart = left;
                   windowEnd = right; 
                }
                
                if(targetCharMap.containsKey(leftChar)) {
                    matchedCharMap.put(leftChar, matchedCharMap.get(leftChar) - 1);
                    if(matchedCharMap.get(leftChar) < targetCharMap.get(leftChar)) {
                        matched--;
                    }
                }
                left++;
            }
        }
        return (windowStart >= 0 && windowEnd >= 0 ) ? s.substring(windowStart, windowEnd+1) : "";
    }
}
```