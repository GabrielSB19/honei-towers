/*
 * This program prints per plain text file,
 * because Eclipse does not print all of the output
 * in the correct way.
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static Scanner sc;
	public static BufferedWriter bw;
	
	public static final String data = "data/Output.txt";
	
	public static int[] stack = new int[3];
	
	public static void main(String [] args) throws IOException {
		sc = new Scanner(System.in);
		bw = new BufferedWriter(new FileWriter(data));
		int amount = Integer.parseInt(sc.nextLine());
		int [] cases = new int [amount];
		repetCase(cases, amount, 0);
		for(int i = 0; i<amount; i++) {
			int n = cases[i];
			stack[0] = n;
			stack[1] = 0;
			stack[2] = 0;
			bw.write(stack[0]+" "+stack[1]+" "+stack[2]+"\n");		
			towers(n, 0, 1, 2);
			bw.write("\n");
		}
		sc.close();
		bw.close();

	}
	
	public static void repetCase(int [] cases, int amount, int a) {
		if(amount>0) {
			cases[a] = Integer.parseInt(sc.nextLine());
			amount--;
			a++;
			repetCase(cases, amount, a);
		}
	}
	
	public static void showCase(int [] cases, int amount, int a) throws IOException {
		if(amount>0) {
			stack[0] = cases[a];
			stack[1] = 0;
			stack[2] = 0;
			bw.write(stack[0]+" "+stack[1]+" "+stack[2]+"\n");		
			towers(cases[a], 0, 1, 2);
			bw.write("\n");
			amount--;
			a++;
			showCase(cases, amount, a);
		}
	}
	
	public static void towers(int n, int o, int a, int d) throws IOException {
		if (n == 1) {
			move(o, d);
			bw.write(stack[0]+" "+stack[1]+" "+stack[2]+"\n");
		} else {
		    towers(n-1, o, d, a);
		    move(o, d);
			bw.write(stack[0]+" "+stack[1]+" "+stack[2]+"\n");
		    towers(n-1, a, o, d);
		}
	}
	
	public static void move(int o, int d) {
		stack[o] = stack[o]-1;
		stack[d] = stack[d]+1;
	}
	
	
}



