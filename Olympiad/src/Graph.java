import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("input.in");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			OutputStream f = new FileOutputStream("output.out", false);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);

			String strLine = br.readLine();

			int num = Integer.parseInt(strLine);

			int[][] matrix = new int[num][num];

			int lineCount = 0;

			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
				for (int i = 0; i < arrTemp.length; i++) {
					matrix[lineCount][i] = Integer.parseInt(arrTemp[i]);
				}
				lineCount++;
			}

			Queue<Integer> queue = new LinkedList<Integer>();

			int[] result = new int[num];

			Boolean[] visited = new Boolean[num];

			for (int i = 0; i < num; i++) {
				visited[i] = false;
			}

			int counter = 0;

			if (visited[0] == false) {
				queue.add(1);
				visited[0] = true;
				while (!queue.isEmpty()) {
					int a = queue.peek();
					result[a - 1] = counter;
					queue.remove();
					for (int j = 0; j < num; j++) {
						if (matrix[a - 1][j] == 1 && visited[j] == false) {
							queue.add(j + 1);
							visited[j] = true;
						}
					}
					counter++;
				}
			}

			Boolean a = true;
			for (Boolean i : visited) {
				if (i == false) {
					out.write("NO");
					a = false;
					break;
				}
			}
			if (a == true) {
				out.write("YES");
			}

			out.close();
			br.close();
		} catch (IOException e) {
		}
	}
}