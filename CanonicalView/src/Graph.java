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
			
			while ((strLine = br.readLine()) != null) {
				String[] arrTemp = strLine.split(" ");
			    arr[Integer.parseInt(arrTemp[1]) - 1][0] = Integer.parseInt(arrTemp[1]);
			    arr[Integer.parseInt(arrTemp[1]) - 1][1] = Integer.parseInt(arrTemp[0]);			    
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
