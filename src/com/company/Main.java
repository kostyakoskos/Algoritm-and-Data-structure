package com.company;

public class Main {
    public static void main(String[] args) {
	double D = 1, q = 5, num = 5;
	while(D <= (q - 1) * num){
	    D = Math.ceil( q * D / (q - 1));
    }
	System.out.println( q * num + 1 - D);
    }

}
