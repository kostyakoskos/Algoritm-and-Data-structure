import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

class MC {
	public static int multiplyOrder(int[] p) {
		int num = p.length;
		int[][] dp = new int[num][num];
		for (int i = 0; i < num; ++i) {
			dp[i][i] = 0;
		}
		for (int l = 1; l < num; ++l) {
			for (int i = 0; i < num - l; ++i) {
				int j = i + l;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; ++k) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1]);
				}
			}
		}
		return dp[0][num - 1];
	}

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
			int[] test = new int[num];
			int c = 0;
			while ((s = b.readLine()) != null) {
				
			}
			o.close();
			b.close();
		} catch (IOException e) {
		}
		//System.out.println(MC.multiplyOrder(test));
	}
}