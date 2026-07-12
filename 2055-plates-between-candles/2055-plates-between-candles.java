import java.util.*;

class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {

        int n = s.length();

        int[] prefix = new int[n];
        List<Integer> candles = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '*') {
                count++;
            } else {
                candles.add(i);
            }

            prefix[i] = count;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            int leftIndex = lowerBound(candles, left);
            int rightIndex = upperBound(candles, right) - 1;

            if (leftIndex >= candles.size() || rightIndex < 0 || leftIndex > rightIndex) {
                ans[i] = 0;
            } else {

                int leftCandle = candles.get(leftIndex);
                int rightCandle = candles.get(rightIndex);

                ans[i] = prefix[rightCandle] - prefix[leftCandle];
            }
        }

        return ans;
    }

    private int lowerBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    private int upperBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}