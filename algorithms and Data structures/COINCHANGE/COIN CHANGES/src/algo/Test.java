package algo;
import java.util.Scanner;

import algo.DynamicAlgo;
import algo.GreedyAlgo;

public class Test {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Scanner in = new Scanner(System.in);

		

		
			System.out.print("Enter coin denominations with a space between them : ");
			String input = in.nextLine();
			int[] denominationsofcoins = getArrayFromString(input);
			System.out.println("Enter N");
			int N = keyboard.nextInt();
			System.out.println("....Greedy algorithm output....");
			GreedyAlgo gLogic = new GreedyAlgo();
			gLogic.minimumCoins(denominationsofcoins, denominationsofcoins.length, N);
			System.out.println(".......Dynamicprogramming output.......");
			DynamicAlgo dLogic = new DynamicAlgo();
			dLogic.count(denominationsofcoins, denominationsofcoins.length, N);
		

	}
	
	public static int[] getArrayFromString(String input) {
		
		String[] StringInput = input.split(" ");
		int length = StringInput.length;
		int[] coinDenominations = new int[length];
		
		for (int i = 0; i < length; i++) {
			coinDenominations[i] = Integer.parseInt(StringInput[i]);
		}
		
		return coinDenominations;
		
	}

}
