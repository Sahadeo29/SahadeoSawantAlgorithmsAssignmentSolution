package com.GL.GradedAssignment2.Part2.BinarySearch;

//Search a specific stock price
public class BinarySearch {
	public void searchValue(double[] csp, double keyValue) {
		int left = 0;
		int right = csp.length - 1;
		int mid = left + (right - left) / 2;

		while (left <= right) {

			if (keyValue < csp[mid]) {

				right = mid - 1;
			} else if (keyValue > csp[mid]) {

				left = mid + 1;

			} else {
				System.out.println("Stock of value " + keyValue + " is present ");
				break;
			}
			mid = left + (right - left) / 2;
		}

		if (left > right) {
			System.out.println("Value not found");
		}
	}

}
