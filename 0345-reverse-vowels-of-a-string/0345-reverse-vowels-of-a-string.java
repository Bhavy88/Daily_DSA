class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while(left < right){
            if("aeiouAEIOU".indexOf(arr[left]) == -1){
                left++;
            }
            else if("aeiouAEIOU".indexOf(arr[right]) == -1){
                right--;
            }
            else{
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    }
}