class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

    int n = nums.length;
    int count = 0;
    int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                count = 0;
            }
            else{
                count++;
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}