class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] item : items1){
            map.put(item[0],item[1]);
        }

        for (int[] item : items2) {
        map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        TreeMap<Integer, Integer> tree = new TreeMap<>(map);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        List<List<Integer>> ans = new ArrayList<>();

        for (int key : keys) {
            ans.add(Arrays.asList(key, map.get(key)));
        }
        return ans;
    }
}