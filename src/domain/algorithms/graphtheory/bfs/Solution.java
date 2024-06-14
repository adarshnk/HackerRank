package domain.algorithms.graphtheory.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            int noOfVertices = sc.nextInt();
            Graph g = new Graph(noOfVertices);
            int noOfEdges = sc.nextInt();
            for (int j = 0; j < noOfEdges; j++) {
                g.addEdge(sc.nextInt(), sc.nextInt());
            }
            int startIndex = sc.nextInt();
            
            for (int k = 1; k <= noOfVertices; k++) {
                g.bfs(startIndex, k);
            }
            System.out.println();
        }
        sc.close();
    }
}

class Graph {
    final static int EDGE_COST = 6;
    int vertices;
    LinkedList<Integer> [] adjacentNodes;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacentNodes = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacentNodes[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v, int w) {
        adjacentNodes[v - 1].add(w);
        adjacentNodes[w - 1].add(v);
    }
    
    public void bfs(int startNode, int destNode) {
        int cost = -1;
        boolean destNodeFound = false;
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        
        if (startNode == destNode) {
            return;
        }
        
        visited[startNode - 1] = true;
        queue.add(startNode);
        
        while(!queue.isEmpty()) {
            /*int node = queue.poll();
            if (!path.isEmpty() && path.size() > 1)
            	path.removeLast();*/
            /*int node = queue.poll();
            if (!path.isEmpty() && !adjacentNodes[path.peekLast() - 1].contains(node))
            	path.removeLast();*/
        	int node = queue.pollLast();
        	while(!path.isEmpty() && !adjacentNodes[path.peekLast() - 1].contains(node)) {
        		path.removeLast();
        	}
            path.add(node);
            Iterator<Integer> it = adjacentNodes[node - 1].listIterator();
            while(it.hasNext()) {
                int nextNode = it.next();
                if (destNode == nextNode) {
                    destNodeFound = true;
                    cost = path.size() * EDGE_COST;
                    break;
                }
                if (!visited[nextNode - 1]) {
                    visited[nextNode - 1] = true;
                    queue.add(nextNode);
                }
            }
            if (destNodeFound)
                break;
        }
        System.out.print(cost + " ");
    }
}
