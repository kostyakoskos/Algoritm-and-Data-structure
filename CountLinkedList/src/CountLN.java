import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CountLN {
	// Represents the node of list.
	public static class Node {
		int data; // значение в узле
		Node next; // указатель на следующий элемент

		public Node(int data) {
			this.data = data;
		}
	}

	static int Josephus(int m, int n) {
		Node head1 = new Node(1);
		Node prev = head1;
		for (int i = 2; i <= n; i++) {
			prev.next = new Node(i);
			prev = prev.next;
		}

		// Connect last node to first
		prev.next = head1;

		/*
		 * while only one node is left in the linked list
		 */
		Node ptr1 = head1, ptr2 = head1;

		while (ptr1.next != ptr1 && n > 1) {
			// Find m-th node
			int count = 1, q = m;
			while (q > n) {
				q %= n;
				// flag = false;
			}
			if (q == 0) {
				q = n;
			}
			while (count != q) {
				ptr2 = ptr1;
				ptr1 = ptr1.next;
				count++;
			}
			/* Remove the m-th node */
			if (prev.next == ptr1) {
				prev.next = head1.next;
				head1 = head1.next;
				ptr1 = ptr1.next;
				ptr2.next = ptr2.next;// ptr2.next
			} else if (ptr1.next == head1) {
				prev = ptr2;
				ptr2.next = ptr1.next;
				ptr1 = head1;
			} else {
				ptr2.next = ptr1.next;
				ptr1 = ptr2.next;
			}
			n--;
		}
		//System.out.println(ptr1.data);
		return (ptr1.data);
	}

	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("in.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine = br.readLine();
			int n = 0, m = 0, kWin = 0;
			String[] arr = new String[3];
			arr = strLine.split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			kWin = Integer.parseInt(arr[2]);
			OutputStream f = new FileOutputStream("out.txt", false);
			OutputStreamWriter w = new OutputStreamWriter(f);
			BufferedWriter o = new BufferedWriter(w);
			int k1 = Josephus(m, n);
			o.write(k1 + "\r\n");
			int difference = Math.abs(k1 - 1);
			if (kWin - difference < 1) {
				kWin += n;
			}
			o.write(Integer.toString(kWin - difference));
			o.close();
			br.close();
		} catch (IOException e) {}
	}
}