import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MinTime {
	public static void main(String arg[]) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			OutputStream f = new FileOutputStream("output.txt", false);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);

			String strLine = br.readLine();
			int num = 0, counter = 0;

			num = Integer.parseInt(strLine);
			
			int arr[][] = new int[num][3];
			while ((strLine = br.readLine()) != null) {
				for (int i = 0; i < 3; i++) {
					arr[counter][i] = Integer.parseInt(strLine.split(" ")[i]);
				}
				counter++;
			}

			int res[] = new int[num];

			if (num == 1) {
				out.write(Integer.toString(arr[0][0]));
			} else if (num == 2) {
				out.write(Integer.toString(Math.min(arr[0][0] + arr[1][0], arr[0][1])));
			} else {
				res[num - 1] = arr[num - 1][0];
				res[num - 2] = Math.min(arr[num - 2][0] + arr[num - 1][0], arr[num - 2][1]);
				res[num - 3] = Math.min(Math.min(arr[num - 3][0] + arr[num - 2][0] + arr[num - 1][0], 
						arr[num -  3][1] + arr[num - 1][0]), Math.min(arr[num - 3][2], arr[num - 3][0] + arr[num - 2][1]));
//				for (int i = 3; i < num; i++) {
//					res[i] = Math.min(Math.min(arr[i - 2][2] + res[i - 3], arr[i - 1][1] + res[i - 2]),
//							arr[i][0] + res[i - 1]);
//				}
				for(int i = num - 4; i >= 0; i--) {
					res[i] = Math.min(Math.min(arr[i][0] + res[i + 1], arr[i][1] + res[i + 2]),
							arr[i][2] + res[i + 3]);
				}
				out.write(Integer.toString(res[0]));
			}
			br.close();
			out.close();
		} catch (IOException e) {
		}
	}
}
