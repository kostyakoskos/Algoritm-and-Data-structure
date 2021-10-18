import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Graph {
	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream("input.in");
			BufferedReader b = new BufferedReader(new InputStreamReader(fs));
			OutputStream f = new FileOutputStream("output.out", true);
			OutputStreamWriter w = new OutputStreamWriter(f);
			BufferedWriter o = new BufferedWriter(w);
			String s;
			Boolean flag = true;
			int num = 0, counter = 0;
			while ((s = b.readLine()) != null) {
				num = Integer.parseInt(s);
				break;
			}

			int[][] matrix = new int[num][num];

			while ((s = b.readLine()) != null) {
				for (int j = 0; j < num; j++) {
					matrix[counter][j] = Integer.parseInt(s.split(" ")[j]);
				}
				counter++;
			}
			
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					if(matrix[i][j] != matrix[j][i] || (i == j && matrix[i][j] == 1)) {//
						o.write("NO");	
						flag = false;
						i = num;
						break;
					}
				}
			}
			
			if(flag == true) {
				o.write("YES");
			}			
			o.close();
			b.close();
		} catch (IOException e) {
		}
	}
}
