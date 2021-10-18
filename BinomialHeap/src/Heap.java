import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Heap {
	public static void binar(long a) {
		try {
			OutputStream f = new FileOutputStream("output.txt", true);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			Boolean flag = false;
			long b, counter = 0;
			String temp = "";
			while (a != 0) {
				b = a % 2;
				temp = b + temp;
				if (b == 1) {
					out.write(Long.toString(counter) + "\r\n");
					flag = true;
				}
				counter++;
				a = a / 2;
			}
			if(flag == false) {
				out.write("-1");
			}
			out.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine = br.readLine();
			binar(Long.parseLong(strLine));
			br.close();
		} catch (IOException e) {
		}
	}
}
