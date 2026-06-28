class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        PriorityQueue<Pair> pq =new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int currDist = current.weight;

            if (currDist > dist[node])
                continue;

            for (Pair neighbour : graph.get(node)) {

                int nextNode = neighbour.node;
                int edgeWeight = neighbour.weight;

                if (currDist + edgeWeight < dist[nextNode]) {

                    dist[nextNode] = currDist + edgeWeight;

                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}