class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int ans = 0;
        int mx = 0;
        int pre = Integer.MIN_VALUE;

        int i = 0;

        while(i < n){
            int j = i + 1;
            while(j<n&& s.charAt(j) == s.charAt(i)){
                j++;
            }
            int cur = j - i;

            if(s.charAt(i) == '1'){
                ans += cur;
            }
            else{
                mx = Math.max(mx, pre + cur);
                pre = cur;
            }
            i = j;
        }
        return ans + mx;
    }
}