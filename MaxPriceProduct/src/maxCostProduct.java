import java.util.*;
import java.lang.*;
import java.io.*;

// функция возращает список значений. надо эти значения записать куда-то

//функция должна принимать массив вместо строки и работать с эти массиво

/* Complexity O(n*n!) */
class maxCostProduct {
	public static ArrayList<String> strPerm(String str, ArrayList<String> list) {
		int len = str.length();

		if (len == 1) {
			list.add(str);
			return list;
		}

		list = strPerm(str.substring(0, len - 1), list);
		int ls = list.size();
		char ap = str.charAt(len - 1);
		for (int i = 0; i < ls; i++) {
			String temp = list.get(i);// берем сначала первый символ из листа, потом второй, третий,.....
			int tl = temp.length();
			for (int j = 0; j <= tl; j++) {
				list.add(temp.substring(0, j) + ap + temp.substring(j, tl));
			}
		}

		while (true) {
			String temp = list.get(0);
			if (temp.length() < len)
				list.remove(temp);
			else
				break;
		}

		return list;
	}	
	// вместо строк передаем массив строк и тусуем между собой элементы массива а не сиволы в строке
//	public static ArrayList<String> strPerm(ArrayList<String> nums, ArrayList<String> list) {
//		
//		int len1 = nums.size();// длинна коллекции		
//		
//		if(len1 == 1) {
//			list.add(nums.get(0));
//			return list;
//		}
//
//		
//		// уменьшаем массив на 1 элемент
//		nums.remove(nums.size() - 1);
//		list = strPerm(nums, list);
//
//		int ls = list.size();// 1
//		
//		String ap = nums.get(nums.size() - 1);
//
//		for(int i = 0; i < ls; i++) {
//			ArrayList<String> temp = new ArrayList<>();
//			temp.add(list.get(i));
//			int ts = temp.size();
//			for (int j = 0; j <= ts; j++) {
//				list.add(temp.subList(0, j) + ap + temp.subList(j, ts));
//			}
//		}
//
//		return list;
//	}
	
	public static void main(String[] args) throws java.lang.Exception {
		
//		ArrayList<String> buyer = new ArrayList<String>();
//		buyer.add("8");
//		buyer.add("9");
//		
//		ArrayList<String> seller = new ArrayList<String>();
//		seller.add("1");
//		seller.add("2");
//		seller.add("3");
//		ArrayList<String> a = new ArrayList<String>();
//		ArrayList<String> listBuyer = new ArrayList<>();
//		int m = 0;
//		for (String i : buyer) {			
//			listBuyer.addAll(strPerm(buyer.get(m), listBuyer));
//			m++;
//		}
//		m = 0;
//		ArrayList<String> listSeller = new ArrayList<>();
//		for (String k : seller) {
//			listSeller.addAll(strPerm(seller.get(m), listSeller));
//			m++;
//		}
		
		int nums[] = new int[3];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		
		int maxSum = 0;
		int minSum = nums[0];
		for(int i = 0; i < nums.length; i++) {
			maxSum += nums[i];
		}
		
		int comb[] = new int[maxSum - minSum + 2];
		
		comb[0] = 1;
		
		int len = comb.length;
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = len; j >= 1 ; j--) {
				if(comb[j] == nums[i] ||
						comb[j] == nums[i] + comb[j - nums[i]]) {
					
				}
			}
		}
		
		String str = "123";
		String str1 = "89";

		
		ArrayList<String> nums = new ArrayList<>();
		nums.add("1");
		nums.add("2");
		nums.add("3");
		
		
		ArrayList<String> listNums = new ArrayList<>();
		//listNums = strPerm(nums, listNums);
		
		
		int maxCost = 0;
;
		int len = 0;
		int result = 0;
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		list = strPerm(str, list);
		for(String i: list) {
			System.out.println(i);
		}
		list1 = strPerm(str1, list1);

		// All Value of seller money
		HashSet<Integer> sellerMoney = new HashSet<Integer>();

		// All Value of buyer money
		HashSet<Integer> buyerMoney = new HashSet<Integer>();

		
		//differ between buer and seller
		HashSet<Integer> differMoney = new HashSet<Integer>();
		
		System.out.println("Total Permutations : " + list.size());
		while (len < str.length()) {

			for (int i = 0; i < list.size(); i++) {
				// System.out.println(list.get(i).substring(0, str.length() - len));
				if (list.get(i).substring(0, str.length() - len).length() <= 1) {
					// печатаем просто цифру
					// разбиваем строку посимвольно
					char[] chars = list.get(i).substring(0, str.length() - len).toCharArray();
					sellerMoney.add(Character.getNumericValue(chars[0]));
				} else if (list.get(i).substring(0, str.length() - len).length() >= 2) {
					// разбиваем строку посимвольно
					char[] chars = list.get(i).substring(0, str.length() - len).toCharArray();

					// запускаем цикл по цифрам и суммируем цифры
					for (int k = 0; k < list.get(i).substring(0, str.length() - len).length(); k++) {
						result += Character.getNumericValue(chars[k]);
					}
					sellerMoney.add(result);
					result = 0;
				}
			}
			len++;
		}
		System.out.println("Combination of money seller");
		for (int i : sellerMoney) {
			System.out.println(i);
		}

		System.out.println();
		
		len = 0;
		while (len < str1.length()) {

			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).substring(0, str1.length() - len).length() <= 1) {
					// печатаем просто цифру
					// разбиваем строку посимвольно
					char[] chars = list1.get(i).substring(0, str1.length() - len).toCharArray();
					buyerMoney.add(Character.getNumericValue(chars[0]));
				} else if (list1.get(i).substring(0, str1.length() - len).length() >= 2) {
					// разбиваем строку посимвольно
					char[] chars = list1.get(i).substring(0, str1.length() - len).toCharArray();

					// запускаем цикл по цифрам и суммируем цифры
					for (int k = 0; k < list1.get(i).substring(0, str1.length() - len).length(); k++) {
						result += Character.getNumericValue(chars[k]);
					}
					buyerMoney.add(result);
					result = 0;
				}
			}
			len++;
		}
		
		System.out.println("Combination of money buyer");
		for (int i : buyerMoney) {
			System.out.println(i);
		}

		System.out.println();
		System.out.println("All combiantion of difference");
		// берем все комбинации денег покупателя
		for (int i : buyerMoney) {
			// берем поочереди все комбинации денег продавца				
				for(int k : sellerMoney) {
					if(i - k >= 0 && i >= 0 && k >= 0) {
						differMoney.add(i);
						differMoney.add(i - k);
					}
				}			
		}
		int finishMaxPrice = Collections.max(differMoney);
		List<Integer> differ = new ArrayList<Integer>();
		for (int i : differMoney) {
			differ.add(i);
			System.out.println(i);
		}
		Collections.sort(differ);
		Collections.reverse(differ);
		System.out.println("After Sort: ");
		for (int i : differ) {
			if(finishMaxPrice - i == 0 || finishMaxPrice - i == 1) {
				finishMaxPrice = i;
			}
			else {
				result = finishMaxPrice - 1;
				break;
			}
		}
		System.out.println(result);	
		
	}
}