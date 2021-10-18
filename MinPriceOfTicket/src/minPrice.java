import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class minPrice {
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			ArrayList<String> myLine = new ArrayList<>();
			int numBuyer = 0, count = 0;

			while ((strLine = br.readLine()) != null) {
				numBuyer =  Integer.parseInt(strLine);
				break;
			}
			
			int numOne[] = new int[numBuyer];
			int numTwo[] = new int[numBuyer];
			int numThree[] = new int[numBuyer];
			
			while ((strLine = br.readLine()) != null) {
			    numOne[count] =  Integer.parseInt(strLine.split(" ")[0]);
			    numTwo[count] =  Integer.parseInt(strLine.split(" ")[1]);
			    numThree[count] =  Integer.parseInt(strLine.split(" ")[2]);
				count++;
			}
			
			for(int i = 0; i < numBuyer; i++) {
				System.out.println(numOne[i]);
				System.out.println(numTwo[i]);
				System.out.println(numThree[i]);
			}
			
			int resultArr[] = new int[numBuyer];
			
			for(int i = 0; i < numBuyer; i++) {
				
			}
			
		} catch (IOException e) {
			System.out.println("Îøèáêà");
		}
	}
}
