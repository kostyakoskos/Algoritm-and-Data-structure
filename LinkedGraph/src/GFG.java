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
	
	static void printAnswer(Graph graph) {
		try {
			Boolean flag = true;
			OutputStream f = new FileOutputStream("output.out", false);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			for (int v = 0; v < graph.V; v++) {
				if(graph.adjListArray[v].size() == 0) {
					flag = false;
				}
			}
			if(flag == true) {
				out.write("YES");
			}
			else {
				out.write("NO");
			}
			out.close();
		} catch (IOException e) {
		}
	}
	
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("input.in");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();

			String[] arr = strLine.split(" ");

			int numVertices = Integer.parseInt(arr[0]);

			Graph graph = new Graph(numVertices);

			int posCount = 0, lineCount = 0;
			
			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
				posCount = 0;
				for(int i = 0; i < arrTemp.length; i++) {
					if(Integer.parseInt(arrTemp[i]) == 1) {
						addEdge(graph, posCount, lineCount);
						posCount++;
					}
					else {
						posCount++;
					}
				}
				lineCount++;
			}

			printAnswer(graph);

			br.close();
		} catch (IOException e) {
		}
	}
}