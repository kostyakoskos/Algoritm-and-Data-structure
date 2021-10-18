import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

//class MC {
//	public class MatrixChain {  
//	    public static int multiplyOrder(int[] p) {
//	    int n = p.length;
//	    int[][] dp = new int[n][n];
//	    
//	    for (int i = 0; i < n; ++i) {
//	      dp[i][i] = 0;
//	    }
//	    
//	    for (int l = 1; l < n; ++l) {
//	      for (int i = 0; i < n - l; ++i) {
//	        int j = i + l;
//	        dp[i][j] = Integer.MAX_VALUE;
//	        for (int k = i; k < j; ++k) {
//	          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1]);
//	        }
//	      }
//	    }
//	    return dp[0][n - 1]; 
//	  }
//
//	public static void main(String[] args) {
////		try {
////			FileInputStream fs = new FileInputStream("input.txt");
////			BufferedReader b = new BufferedReader(new InputStreamReader(fs));
////			OutputStream f = new FileOutputStream("output.txt", true);
////			OutputStreamWriter w = new OutputStreamWriter(f);
////			BufferedWriter o = new BufferedWriter(w);
////			String s;
////			Boolean flag = true;
////			int num = 0, counter = 0;			
////			while ((s = b.readLine()) != null) {
////				num = Integer.parseInt(s);
////				break;
////			}
////			int[] test = new int[num + 1];
////			int c = 0;
////			while ((s = b.readLine()) != null) {
////				String[] arr = s.split(" ");
////				test[c] = Integer.parseInt(arr[0]);
////				c++;
////				test[c] = Integer.parseInt(arr[1]);
////				c++;
////				break;
////			}
////			while ((s = b.readLine()) != null) {
////				String[] arr = s.split(" ");
////				test[c] = Integer.parseInt(arr[1]);
////				c++;
////			}
////			System.out.println(MC.multiplyOrder(test));
////			o.write(MC.multiplyOrder(test));
////			o.close();
////			b.close();
////		} catch (IOException e) {
////		}
////	    int[] test = new int[4];
////	    test[0] = 10;
////	    test[1] = 100;
////	    test[2] = 5;
////	    test[3] = 50;
//	    int[] test = { 10, 100, 5, 50 };
//	    System.out.println(MC.multiplyOrder(test));
//		
//	}
//}
class MC {  
    public static int multiplyOrder(int[] p) {
    int n = p.length + 5;
    int[][] dp = new int[n][n];
    
    for (int i = 0; i < n; ++i) {
      dp[i][i] = 0;
    }
    
    for (int l = 1; l < n; ++l) {
      for (int i = 0; i < n - l; ++i) {
        int j = i + l;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
          dp[i][j] = Math.min(dp[i][j],
                                        dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1]);
        }
      }
    }
    return dp[0][n - 1]; 
  }
  
  public static void main(String[] args) {
    int[] test = { 10, 100, 5, 50 };
    System.out.println(MC.multiplyOrder(test));
  }
}