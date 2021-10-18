import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Josephus {
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("in.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			double D = 1, q = 5, qFirst = 5, num = 5, k = 0, kWin = 5;
			while ((strLine = br.readLine()) != null) {
				num = Integer.parseInt(strLine.split(" ")[0]);
				q = Integer.parseInt(strLine.split(" ")[1]);
				kWin = Integer.parseInt(strLine.split(" ")[2]);
			}
			qFirst = q;
			if (q > num) {
				while (q > num) {
					q %= num;
					if (q == 1) {
						q = num + 1;
						break;
					} else if (q == num - 1) {
						q += num;
						break;
					} else if (q == 0) {
						q = qFirst;
						break;
					} else if (q == num / 2) {
						q += num;
						break;
					}
				}
			}

			if(q == 0) {
				while (D <= (q - 1) * num) {
					D = Math.ceil(q * D / (q - 1));
					System.out.println(D);
				}
			}
			
			while (D <= (q - 1) * num) {
				D = Math.ceil(q * D / (q - 1));
				System.out.println(D);
			}

			k = q * num + 1 - D;
			OutputStream f = new FileOutputStream("out.txt", false);
			OutputStreamWriter w = new OutputStreamWriter(f);
			BufferedWriter o = new BufferedWriter(w);
			o.write(Integer.toString((int) k) + "\r\n");
			int difference = Math.abs((int) (k - 1));
			if (kWin - difference < 1) {
				kWin += num;
			}
			o.write(Integer.toString((int) (kWin - difference)));
			o.close();
			br.close();
		} catch (

		IOException e) {
			// System.out.println("Îøèáêà");
		}
	}
}