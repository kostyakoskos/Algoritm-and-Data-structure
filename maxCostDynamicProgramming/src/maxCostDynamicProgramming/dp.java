package maxCostDynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class dp {
	public static void main(String[] args) {

		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			ArrayList<String> myLine = new ArrayList<>();
			int count = 0, monBuyer = 0, monSeller = 0, resultOut = 0, maxSumBuyer = 0, maxSumSeller = 0;

			while ((strLine = br.readLine()) != null) {
				monBuyer = Integer.parseInt(strLine.split(" ")[0]);
				monSeller = Integer.parseInt(strLine.split(" ")[1]);
				break;
			}
			
			int buyer[] = new int[monBuyer];
			int seller[] = new int[monSeller];
			
			while ((strLine = br.readLine()) != null) {
				if(count == 0) {
					for(int i = 0; i < monBuyer; i++) {
						buyer[i] = Integer.parseInt(strLine.split(" ")[i]);
					}
				}
				if(count == 1) {
					for(int i = 0; i < monSeller; i++) {
						seller[i] = Integer.parseInt(strLine.split(" ")[i]);
					}
					break;
				}
				count++;
			}
	
			for (int i = 0; i < buyer.length; i++) {
				maxSumBuyer += buyer[i];
			}

			int combBuyer[] = new int[maxSumBuyer + 2];

			combBuyer[0] = 1;

			int lenBuyer = combBuyer.length;

			int k = 0;

			for (int i = 0; i < buyer.length; i++) {
				k = buyer[i];
				for (int j = lenBuyer; j >= 1; j--) {
					if (j == k) {
						combBuyer[j] = j;
					}
					if (j - k >= 0 && j == k + combBuyer[j - k]) {
						combBuyer[j] = j;
					}
				}
			}
			
			for (int i = 0; i < seller.length; i++) {
				maxSumSeller += seller[i];
			}

			int combSeller[] = new int[maxSumSeller + 2];

			combSeller[0] = 1;

			int lenSeller = combSeller.length;

			int k1 = 0;

			for (int i = 0; i < seller.length; i++) {
				k1 = seller[i];
				for (int j = lenSeller; j >= 1; j--) {
					if (j == k1) {
						combSeller[j] = j;
					}
					if (j - k1 >= 0 && j == k1 + combSeller[j - k1]) {
						combSeller[j] = j;
					}
				}
			}
			combSeller[0] = 0;
			int r = combBuyer.length;
			int result[] = new int[r - 1];
			for (int i = r - 1; i > 0; i--) {
				for (int p = combSeller.length - 1; p >= 0; p--) {
					if (combBuyer[i] != 0 && combBuyer[i] > combSeller[p]) {
						result[combBuyer[i] - combSeller[p]] = combBuyer[i] - combSeller[p];
					}
				}
			}

			for (int i = result.length - 1; i > 0; i--) {
				if (result[i] != 0) {
					continue;
				}
				if (result[i] == 0) {
					resultOut = result[i + 1] - 1;
					break;
				}
			}

			OutputStream f = new FileOutputStream("output.txt", true);
			OutputStreamWriter writer = new OutputStreamWriter(f);
			BufferedWriter out = new BufferedWriter(writer);
			if(resultOut == 0) {
				out.write("YES");
			}
			else {
				out.write("NO\n");
				out.write(Integer.toString(resultOut));
			}
			out.flush();
		} catch (IOException e) {
			System.out.println("Ошибка");
		}
	}
}
