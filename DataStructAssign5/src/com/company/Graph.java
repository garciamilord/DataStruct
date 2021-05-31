package com.company;


public class Graph {


    public int V, E;
    public Edge edge[];

    public Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    public double[] bellmanFord(int src) {
        double[] dist = new double[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                double weight = -Math.log(edge[j].weight);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Math.exp(dist[i]);
        }
        return dist;
    }
    public void printEdges() {
        for (Edge e : edge) {
            System.out.println(e.src + " to " + e.dest + " is " + e.weight);
        }
    }
    class Edge {
        int src, dest;
        double weight;

        public Edge() {
            src = dest = 0;
            weight = 0;
        }
    }
}

