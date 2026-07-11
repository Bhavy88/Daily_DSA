class Solution {

    int nodes;
    int edges;

    public int countCompleteComponents(int n, int[][] edgesArr) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edgesArr) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                nodes = 0;
                edges = 0;

                dfs(i, graph, visited);

                edges /= 2;

                if (edges == nodes * (nodes - 1) / 2)
                    answer++;
            }
        }

        return answer;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] visited) {

        visited[node] = true;

        nodes++;

        edges += graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}