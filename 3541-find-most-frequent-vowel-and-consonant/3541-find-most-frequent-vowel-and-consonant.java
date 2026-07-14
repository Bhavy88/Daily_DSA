class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        int vowel = 0;
        int consonant = 0;

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i = 0;i < 26;i++){
            char ch = (char) (i + 'a');

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowel = Math.max(vowel, freq[i]);
            }
            else{
                consonant = Math.max(consonant, freq[i]);
            }
        }
        return vowel + consonant;
    }
}