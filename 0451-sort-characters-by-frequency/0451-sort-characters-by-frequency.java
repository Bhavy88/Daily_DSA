import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            bucket[i] = new ArrayList<>();
        }

        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            bucket[freq].add(ch);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = s.length(); i >= 1; i--) {
            for (char ch : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}