class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        int area = 0;

        while(left < right){
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            area = h * width;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]){
            left++;
            }
            else{
                right--;
            }
        }

        
    return maxArea;
    }
}