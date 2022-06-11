package questions.slidingWindowPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubStringConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
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

	public static void main(String[] args) {
		findSubstring("wordgoodgoodgoodbestword",
				new String[]{"word","good","best","good"});


	}
}
