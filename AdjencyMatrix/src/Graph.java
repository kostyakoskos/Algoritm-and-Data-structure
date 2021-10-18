import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Graph {
	private boolean adjMatrix[][];
	private int numVertices;

	public Graph(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
	}

	public void addEdge(int i, int j) {
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numVertices; i++) {
			for (boolean j : adjMatrix[i]) {
				s.append((j ? 1 : 0) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			OutputStream f = new FileOutputStream("output.txt", false);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			
			String strLine = br.readLine();
			
			String[] arr = strLine.split(" ");
			
			int numVertices = Integer.parseInt(arr[0]);
			
			Graph g = new Graph(numVertices);
			
			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
				g.addEdge(Integer.parseInt(arrTemp[0]) - 1, Integer.parseInt(arrTemp[1]) - 1);
			}
			
			out.write(g.toString());
			
			br.close();
			out.close();
		} catch (IOException e) {
		}
	}
}