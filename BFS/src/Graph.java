
// Java program to print BFS traversal from a given source vertex. 
// BFS(int s) traverses vertices reachable from s. 
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list 
// representation 
public class Graph {
	static int num = 0;
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists
	// Constructor

	Graph(int v) {
		// V1 = v;
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	static boolean visit1[] = new boolean[num];

	// prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		try {
			OutputStream f = new FileOutputStream("output.txt", true);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			while (queue.size() != 0) {
				// Dequeue a vertex from queue and print it
				s = queue.poll();
				out.write(Long.toString(1 + s) + " ");
				//System.out.print(s + " ");
				// out.write(s + " ");
				// Get all adjacent vertices of the dequeued vertex s
				// If a adjacent has not been visited, then mark it
				// visited and enqueue it
				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited[n] && !visit1[n]) {
						visited[n] = true;
						visit1[n] = true;
						queue.add(n);
					}
				}
			}
			out.close();
		} catch (IOException e) {
		}

	}

	// Driver method to
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();

			num = Integer.parseInt(strLine);

			Graph g = new Graph(num);

			int posCount = 0, lineCount = 0;

			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
				posCount = 0;
				for (int i = 0; i < arrTemp.length; i++) {
					if (Integer.parseInt(arrTemp[i]) == 1) {
						g.addEdge(lineCount, posCount);
						posCount++;
					} else {
						posCount++;
					}
				}
				lineCount++;
			}
			for (int i = 0; i < num; i++) {
				if (visit1[i] == false) {
					g.BFS(i);
				}
			}

			br.close();
		} catch (IOException e) {
		}
	}
}