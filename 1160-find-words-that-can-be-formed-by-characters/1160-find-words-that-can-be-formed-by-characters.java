class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] count = new int[26];

        // Count frequency of chars
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }

        int ans = 0;

        // Check each word
        for (String word : words) {

            int[] temp = new int[26];
            boolean valid = true;

            for (char c : word.toCharArray()) {
                temp[c - 'a']++;

                if (temp[c - 'a'] > count[c - 'a']) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += word.length();
            }
        }

        return ans;
    }
}