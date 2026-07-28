class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        String middle = "";

        for(char ch = 'a'; ch <= 'z'; ch++){
            int half = count[ch - 'a'] / 2;
            while (half-- > 0) {
                left.append(ch);
            }
            if (count[ch - 'a'] % 2 == 1) {
                middle = String.valueOf(ch);
            }
        }
        String firstHalf = left.toString();

        return firstHalf + middle + new StringBuilder(firstHalf).reverse().toString();
    }
}