class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int num = entry.getKey();
            int frequency = entry.getValue();

            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(num);
        }

        int[] ans = new int[k];
        int index = 0;

        for(int i = bucket.length - 1; i >= 0 && index < k; i--){

            if(bucket[i] != null){

                for(int num : bucket[i]){
                    ans[index] = num;
                    index++;

                    if(index == k){
                        break;
                    }
                }
            }
        }

        return ans;
    }
}