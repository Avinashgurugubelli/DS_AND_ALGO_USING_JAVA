## Words Concatenation (hard)
Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.

Example 1:
```
Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".
```
Example 2:
```
Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".
```

## Solution #
This problem follows the Sliding Window pattern and has a lot of similarities with Maximum Sum Subarray of Size K. We will keep track of all the words in a HashMap and try to match them in the given string. Here are the set of steps for our algorithm:

- Keep the frequency of every word in a HashMap.
- Starting from every index in the string, try to match all the words.
- In each iteration, keep track of all the words that we have already seen in another HashMap.
- If a word is not found or has a higher frequency than required, we can move on to the next character in the string.
- Store the index if we have found all the words.

## Explanation:
```
Words: ["word", "good", "good", "best"]
S = "wordgoodgoodgoodbestword"

ANS:
---

Desired words frequency: 
------------------------

Word  | Frequency |
------  ---------
word  |  1
good  |  2
best  |  1


i=0:
----
j = 0 -> nxtWordIndex: 0  -> nextWord:  word
j = 1 -> nxtWordIndex: 4  -> nextWord:  good
j = 2 -> nxtWordIndex: 8  -> nextWord:  good
j = 3 -> nxtWordIndex: 12 -> nextWord:  good -> break the inner loop as "good" word repeated 3 times it should be <=2

i=1:
-----
j = 0  -> nxtWordIndex: 1 -> nextWord:  ordg -> break the inner loop as word "ordg" not exists in words array


i=2:
-----
j = 0 -> nxtWordIndex: 2 -> nextWord:  rdgo -> break the inner loop as word "rdgo" not exists in words array

i=3:
-----
j = 0 -> nxtWordIndex: 3 -> nextWord:  dgoo -> break the inner loop as word "dgoo" not exists in words array

i=4:
-----
j = 0 -> nxtWordIndex: 4 -> nextWord:  good
j = 1 -> nxtWordIndex: 8 -> nextWord:  good
j = 2 -> nxtWordIndex: 12 -> nextWord: good -> break the inner loop as "good" word repeated 3 times it should be <=2

Matched frequency:
-----------------
Word  | Frequency |
------  ---------
word  |  0
good  |  3
best  |  0

i=5:
-----
j = 0 -> nxtWordIndex: 5 -> nextWord:  oodg -> break the inner loop as word "oodg" not exists in words array

i=6:
-----
j = 0 -> nxtWordIndex: 6 -> nextWord:  odgo -> break the inner loop as word "odgo" not exists in words array

i=7:
-----
j = 0 -> nxtWordIndex: 7 -> nextWord:  dgoo -> break the inner loop as word "dgoo" not exists in words array

i=8:
---
j = 0 -> nxtWordIndex: 4 -> nextWord:  good
j = 1 -> nxtWordIndex: 8 -> nextWord:  good
j = 2 -> nxtWordIndex: 12 -> nextWord: best
j = 3 -> nxtWordIndex: 8 -> nextWord:  word

Matched frequency:
-----------------
Word  | Frequency |
------  ---------
word  |  1
good  |  2
best  |  1

Desired == matched -> so output -> [8 => i]
```

```
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsCount = words.length;
        int wordLen = words[0].length();
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<String, Integer> wordsFreq = new HashMap<String, Integer>();
        
        for(int i=0; i< words.length; i++) {
            wordsFreq.put(words[i], wordsFreq.getOrDefault(words[i], 0)+1);
        }
        
        for(int i=0; i<= s.length() - wordsCount*wordLen; i++) {
            HashMap<String, Integer> seen = new HashMap<String, Integer>();
            for(int j=0; j< wordsCount; j++) {
                int nextWordIndex = i+j*wordLen;
                String nextWord = s.substring(nextWordIndex, nextWordIndex+wordLen);
                if(!wordsFreq.containsKey(nextWord)) {
                    break;
                }
                seen.put(nextWord, seen.getOrDefault(nextWord, 0) +1);
                
                if(seen.get(nextWord) > wordsFreq.getOrDefault(nextWord, 0)) {
                    break;
                }
                if(j+1 == wordsCount) {
                   resultIndices.add(i);
                }
            }
        }
        return resultIndices;
    }
}
```