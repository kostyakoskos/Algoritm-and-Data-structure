import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Graph {
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			OutputStream f = new FileOutputStream("output.txt", false);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			
			String strLine = br.readLine();
			
			int numVertices = Integer.parseInt(strLine);
			
			int[][] arr = new int[numVertices][2];
			
			int lineCounter = 0, posCounter = 0;
			
			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
				posCounter = 0;
				for(int i = 0; i < arrTemp.length; i++) {
					if (Integer.parseInt(arrTemp[i]) == 1) {
						arr[posCounter][0] = posCounter + 1;
						arr[posCounter][1] = lineCounter + 1;
						posCounter++;
					}
					else {
						posCounter++;
					}
				}
				lineCounter++;			    
			}
			
			System.out.println();
			
			for(int i = 0; i < numVertices; i++) {
				out.write(arr[i][1] + " ");
			}
			
			br.close();
			out.close();
		} catch (IOException e) {
		}
	}
}
