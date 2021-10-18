import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Turtle {
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			OutputStream f = new FileOutputStream("output.txt", true);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			String strLine = br.readLine();
			int Imax = Integer.parseInt(strLine.split(" ")[0]), Jmax = Integer.parseInt(strLine.split(" ")[1]);
			if (Jmax == 1) {
				out.write("1");
			} else if (Jmax == 2) {
				out.write(Integer.toString(Imax % 1000000007));
			} else {
				int[] dp1 = new int[Jmax];

				for (int j = 0; j < Jmax; j++) {
					dp1[j] = 1;
				}
				if (Jmax > 2) {
					for (int i = 1; i < Imax; i++) {
						for (int j = 1; j < Jmax; j++) {
							dp1[j] = (dp1[j] + dp1[j - 1]) % 1000000007;
						}
					}
				}
				out.write(Integer.toString(dp1[Jmax - 1]));
			}
			br.close();
			out.close();
		} catch (IOException e) {
		}
	}
}
