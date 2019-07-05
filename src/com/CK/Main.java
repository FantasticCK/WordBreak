package com.CK;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        String s = "dogs";
        wordDict.add("dog");
        wordDict.add("s");
        wordDict.add("gs");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        boolean dp[] = new boolean[s.length() + 1];
        for (int right = 1; right < s.length() + 1; right++) {
            dp[right] = false;
            for (String word : wordDict) {
                boolean temp = false;
                if (s.substring(0, right).endsWith(word)) {
                    int newRight = right - word.length();
                    if (newRight == 0) dp[right] = true;
                    else temp = dp[newRight];
                }
                dp[right] = dp[right]||temp;
            }
        }
        return dp[s.length()];
    }
}
