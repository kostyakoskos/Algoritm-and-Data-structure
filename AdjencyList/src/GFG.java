import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class GFG {
	static class Graph {
		int V;
		LinkedList<Integer> adjListArray[];

		Graph(int V) {
			this.V = V;

			adjListArray = new LinkedList[V];

			for (int i = 0; i < V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}

	static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);

		graph.adjListArray[dest].add(src);
	}

	static void printGraph(Graph graph) {
		try {
			OutputStream f = new FileOutputStream("output.txt", false);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			for (int v = 0; v < graph.V; v++) {
				out.write(graph.adjListArray[v].size() + " ");
				for (Integer pCrawl : graph.adjListArray[v]) {
					out.write((pCrawl + 1) + " ");
				}
				out.write("\r\n");
			}
			out.close();
		} catch (IOException e) {
		}
	}
	
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();

			String[] arr = strLine.split(" ");

			int numVertices = Integer.parseInt(arr[0]);

			Graph graph = new Graph(numVertices);

			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
				addEdge(graph, Integer.parseInt(arrTemp[0]) - 1, Integer.parseInt(arrTemp[1]) - 1);
			}

			printGraph(graph);

			br.close();
		} catch (IOException e) {
		}
	}
}