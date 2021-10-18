import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DijkstraGraph {
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("input1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = br.readLine();

			String[] strLine1 = strLine.split(" ");

			int num = Integer.parseInt(strLine1[0]);
			int numEdge = Integer.parseInt(strLine1[1]);

			int[][] matrix = new int[num][num];

			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");

				matrix[Integer.parseInt(arrTemp[0]) - 1][Integer.parseInt(arrTemp[1]) - 1] = Integer
						.parseInt(arrTemp[2]);
				matrix[Integer.parseInt(arrTemp[1]) - 1][Integer.parseInt(arrTemp[0]) - 1] = Integer
						.parseInt(arrTemp[2]);
			}

			Boolean[] visited = new Boolean[num];
			int[] longPath = new int[num];

			for (int i = 0; i < num; i++) {
				visited[i] = false;
				longPath[i] = 11112;
			}

			int[][] result = new int[num][num];

			int countPlus = 0, min = 11112, minPos = 0, numLine = 0;
			for (int i = 0; i < num; i++) {
				if (visited[minPos] == false) {
					visited[minPos] = true;
					for (int j = 0; j < num; j++) {
						if (matrix[numLine][j] + countPlus < longPath[j] && matrix[numLine][j] != 0 
								&& visited[j] == false) {
							longPath[j] = matrix[numLine][j] + countPlus;
							if(longPath[j] != 0 && longPath[j] < min) {
								min = longPath[j];
								minPos = j;
							}
						}
					}
					numLine = minPos;
					countPlus = min;
					min = 11112;
				}
			}

			System.out.print(longPath[num - 1]);
			
			br.close();
		} catch (IOException e) {
		}
	}
}
