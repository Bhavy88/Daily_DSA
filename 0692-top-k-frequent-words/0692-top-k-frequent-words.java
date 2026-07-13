import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String>[] bucket = new ArrayList[words.length + 1];

        for (int i = 0; i <= words.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (String word : map.keySet()) {
            int freq = map.get(word);
            bucket[freq].add(word);
        }

        List<String> ans = new ArrayList<>();

        for (int i = words.length; i >= 1; i--) {

            Collections.sort(bucket[i]);

            for (String word : bucket[i]) {
                ans.add(word);

                if (ans.size() == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}