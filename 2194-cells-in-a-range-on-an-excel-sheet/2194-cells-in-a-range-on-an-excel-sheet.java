class Solution {
    public List<String> cellsInRange(String s) {
        
        List<String> ans = new ArrayList<>();

        char startCol = s.charAt(0);
        char endCol = s.charAt(3);

        char startRow = s.charAt(1);
        char endRow = s.charAt(4);

        for(char col = startCol; col <= endCol; col++){
            for(char row = startRow; row <= endRow; row++){
                ans.add(""+ col + row);
            }
        }
        return ans;
    }
}