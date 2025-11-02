import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        // --- Setup ---
        // 1. (Your 'str' list) Use List<Integer> for the result
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length(); // Length of each word (n)
        int numWords = words.length;     // Total number of words (m)
        int windowLen = wordLen * numWords;

        // 2. (Your 'hash' map) This map must store the FREQUENCY of each word.
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            // Use getOrDefault to correctly count duplicates
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // --- Sliding Window Logic ---
        
        // 3. We only need to check starting points from 0 up to wordLen.
        // For example, if wordLen=3, we check windows starting at:
        // 0, 3, 6, ...
        // 1, 4, 7, ...
        // 2, 5, 8, ...
        // Any other starting point (like 4) is already covered in a previous check.
        for (int i = 0; i < wordLen; i++) {
            
            // 4. Set up the sliding window for this starting point
            Map<String, Integer> seenWords = new HashMap<>(); // This map tracks words in our *current* window
            int left = i;         // The left edge of the window
            int wordsFound = 0; // Count of valid words in the window

            // 'j' is the right edge, moving one word at a time
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                
                String currentWord = s.substring(j, j + wordLen);

                // 5. Check if the current word is one we need
                if (wordCountMap.containsKey(currentWord)) {
                    // Add it to our 'seen' map
                    seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                    wordsFound++;

                    // 6. If we've seen this word TOO many times, it's invalid.
                    // We must shrink the window from the left until it's valid again.
                    while (seenWords.get(currentWord) > wordCountMap.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLen; // Slide the left edge over
                    }

                    // 7. If we found all the words, we have a match!
                    if (wordsFound == numWords) {
                        result.add(left); // 'left' is the starting index of the valid window
                        
                        // Slide the window forward by one word from the left
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLen;
                    }

                } else {
                    // 8. (Your 'else' block) If the word isn't in our map,
                    // it breaks the sequence. Reset our window and start fresh
                    // from the *next* word.
                    seenWords.clear();
                    wordsFound = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return result;
    }
}