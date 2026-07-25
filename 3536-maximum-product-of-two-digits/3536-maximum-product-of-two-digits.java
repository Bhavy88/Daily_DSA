class Solution {
    public int maxProduct(int n) {
        int Largest = 0;
        int secLargest = 0;


        while(n > 0){
            int digit = n % 10;
            n = n / 10;

            if(digit > Largest){
                secLargest = Largest;
                Largest = digit; 
            }
            else if(digit > secLargest){
                secLargest = digit;
            }
        }
        return Largest * secLargest;
    }
}