import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BinaryHeap {

	static boolean isHeap(String arr[], int n) {
		for (int i = 0; i <= (n - 2) / 2; i++) {
			if (2 * i + 2 < n && Integer.parseInt(arr[2 * i + 2]) < Integer.parseInt(arr[i])
					|| Integer.parseInt(arr[2 * i + 1]) < Integer.parseInt(arr[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream("input.txt");
			BufferedReader b = new BufferedReader(new InputStreamReader(fs));
			OutputStream f = new FileOutputStream("output.txt", false);
			OutputStreamWriter w = new OutputStreamWriter(f);
			BufferedWriter o = new BufferedWriter(w);
			int nu = 0;
			String s = b.readLine();
			nu = Integer.parseInt(s);

			String arr[] = new String[nu];

			while ((s = b.readLine()) != null) {
				arr = s.split(" ");
			}

			if (nu == 1) {
				o.write("Yes");
			} else if (isHeap(arr, nu)) {
				o.write("Yes");
			} else {
				o.write("No");
			}
			o.close();
			b.close();
		} catch (IOException e) {
		}
	}
}