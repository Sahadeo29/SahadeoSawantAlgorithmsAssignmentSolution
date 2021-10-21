package com.GL.GradedAssignment2.Part2.StockersMain;

import java.util.Scanner;

import com.GL.GradedAssignment2.Part2.BinarySearch.BinarySearch;
import com.GL.GradedAssignment2.Part2.MergeSortImplementation.MergeSortImplementation;
import com.GL.GradedAssignment2.Part2.MergeSortImplementation1.MergeSortImplementation1;
import com.GL.GradedAssignment2.Part2.StockersBase.StockersBase;

public class StockersMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of companies:");
		int number = sc.nextInt();
		double[] csp = new double[number]; // Current Stock Price
		boolean[] profit = new boolean[number];
		
		//Enter values
		for (int i = 0; i < number; i++) {
			System.out.println("Enter current stock price of the company" + (i + 1) + ":");
			csp[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compared to yesterday?");
			profit[i] = sc.nextBoolean();
		}
		int choice;
		do {
			System.out.println("-----------------------------------------------\r\n"
					+ "Enter the operation that you want to perform\r\n"
					+ "1. Display the companies stock prices in ascending order\r\n"
					+ "2. Display the companies stock prices in descending order\r\n"
					+ "3. Display the total no of companies for which stock prices rose today\r\n"
					+ "4. Display the total no of companies for which stock prices declined today\r\n"
					+ "5. Search a specific stock price\r\n" + "6. press 0 to exit\r\n"
					+ "-----------------------------------------------");

			MergeSortImplementation mergesortimplementation = new MergeSortImplementation();   //Ascending order CSP
			mergesortimplementation.sort(csp, 0, csp.length - 1);

			MergeSortImplementation1 mergesortimplementation1 = new MergeSortImplementation1(); //Descending order CSP
			mergesortimplementation1.sort(csp, 0, csp.length - 1);

			StockersBase sb = new StockersBase();    //Count of True or False

			BinarySearch bs = new BinarySearch();    //Searches Specific Stock price
			
			//Output as per choice
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				mergesortimplementation.printAscendingCSP(csp);
			}
				break;
			case 2: {
				mergesortimplementation1.printDescendingCSP(csp);
			}
				break;
			case 3: {
				System.out.println("Total no.of companies whose stock prices rose today:" + sb.count(profit));
			}
				break;
			case 4: {
				System.out.println("Total no. of companies whose stock prices declined today:" + (number - sb.count(profit)));
			}
				break;
			case 5: {
				double keyValue;
				System.out.println("enter the key value:");
				keyValue = sc.nextDouble();
				bs.searchValue(csp, keyValue);
			}
				break;
			case 0:
				choice = 0;
				break;

			default:
				System.out.println("Enter a valid choice");
			}

		} while (choice != 0);
		
		System.out.println("Exited Successfully");
		
		sc.close();
	}
}